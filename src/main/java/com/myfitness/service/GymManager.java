package com.myfitness.service;

import com.myfitness.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Central service class for the MyFitness gym system.
 *
 * Acts as the in-memory database using ArrayLists for:
 *   - Members, Staff, Instructors, BootCampClasses, Bookings, Payments
 *
 * Implements Payable to handle all payment processing.
 * Extends BootcampFee to provide the concrete fee calculation (Task 3c).
 */
public class GymManager extends BootcampFee implements Payable {

    // ── In-memory "database" ───────────────────────────────────────────────
    private final List<Member>       members     = new ArrayList<>();
    private final List<Staff>        staff       = new ArrayList<>();
    private final List<Instructor>   instructors = new ArrayList<>();
    private final List<BootCampClass> classes    = new ArrayList<>();
    private final List<Booking>      bookings    = new ArrayList<>();
    private final List<Payment>      payments    = new ArrayList<>();

    private double totalPaid = 0.0;

    // ── ID counters ────────────────────────────────────────────────────────
    private int nextMemberId  = 1;
    private int nextBookingId = 1001;
    private int nextPaymentId = 5001;

    // ══════════════════════════════════════════════════════════════════════
    //  BootcampFee — Task 3c concrete implementation
    // ══════════════════════════════════════════════════════════════════════

    /**
     * Calculates total bootcamp fee.
     * Applies a 7% discount when enrolling in 2 or more classes.
     */
    @Override
    public double calculateFee(int numberOfClasses) {
        if (numberOfClasses <= 0) return 0.0;
        double subtotal = BASE_FEE_PER_CLASS * numberOfClasses;
        if (numberOfClasses >= DISCOUNT_THRESHOLD) {
            return subtotal * (1 - MULTI_CLASS_DISCOUNT);
        }
        return subtotal;
    }

    // ══════════════════════════════════════════════════════════════════════
    //  Payable interface implementation
    // ══════════════════════════════════════════════════════════════════════

    @Override
    public boolean processPayment(double amount) {
        totalPaid += amount;
        return true;
    }

    @Override
    public boolean issueRefund(int paymentId) {
        return findPayment(paymentId)
                .map(p -> p.refund())
                .orElse(false);
    }

    @Override
    public double getTotalPaid() { return totalPaid; }

    // ══════════════════════════════════════════════════════════════════════
    //  MEMBER MANAGEMENT
    // ══════════════════════════════════════════════════════════════════════

    public void addMember(Member member) {
        members.add(member);
        System.out.printf("  ✓ Member added: %s (%s)%n",
                member.getName(), member.getMembershipType());
    }

    public boolean removeMember(int membershipId) {
        Optional<Member> found = findMember(membershipId);
        if (found.isPresent()) {
            members.remove(found.get());
            System.out.printf("  ✓ Member removed: %s%n", found.get().getName());
            return true;
        }
        System.out.printf("  ✗ Member ID %d not found.%n", membershipId);
        return false;
    }

    public Optional<Member> findMember(int membershipId) {
        return members.stream()
                .filter(m -> m.getMembershipId() == membershipId)
                .findFirst();
    }

    public void listAllMembers() {
        if (members.isEmpty()) { System.out.println("  No members registered."); return; }
        members.forEach(m -> System.out.println("  " + m));
    }

    // ══════════════════════════════════════════════════════════════════════
    //  STAFF MANAGEMENT
    // ══════════════════════════════════════════════════════════════════════

    public void addStaff(Staff s) {
        staff.add(s);
        System.out.printf("  ✓ Staff added: %s (%s)%n", s.getName(), s.getRole());
    }

    public void addInstructor(Instructor i) {
        instructors.add(i);
        staff.add(i);
        System.out.printf("  ✓ Instructor added: %s | Spec: %s%n",
                i.getName(), i.getSpecialization());
    }

    public void listAllStaff() {
        if (staff.isEmpty()) { System.out.println("  No staff registered."); return; }
        staff.forEach(s -> System.out.println("  " + s));
    }

    public void listInstructors() {
        if (instructors.isEmpty()) { System.out.println("  No instructors registered."); return; }
        instructors.forEach(i -> System.out.println("  " + i));
    }

    // ══════════════════════════════════════════════════════════════════════
    //  BOOTCAMP CLASS MANAGEMENT
    // ══════════════════════════════════════════════════════════════════════

    public void addClass(BootCampClass bc) {
        classes.add(bc);
        System.out.printf("  ✓ Class added: %s%n", bc.getClassName());
    }

    public boolean enrolMemberInClass(int membershipId, int classId) {
        Optional<Member>       member = findMember(membershipId);
        Optional<BootCampClass> bc    = findClass(classId);

        if (member.isEmpty()) {
            System.out.printf("  ✗ Member ID %d not found.%n", membershipId); return false;
        }
        if (bc.isEmpty()) {
            System.out.printf("  ✗ Class ID %d not found.%n", classId); return false;
        }

        boolean enrolled = bc.get().enrolMember(member.get());
        if (enrolled) {
            // auto-create a booking
            Booking booking = new Booking(nextBookingId++, member.get(), bc.get());
            booking.confirm();
            bookings.add(booking);

            // charge the bootcamp fee
            int classCount = (int) bookings.stream()
                    .filter(b -> b.getMember().equals(member.get()))
                    .filter(bk -> bk.getStatus() == Booking.Status.CONFIRMED)
                    .count();

            double fee = calculateFee(classCount);
            Payment payment = new Payment(nextPaymentId++, member.get(), fee,
                    Payment.Method.CREDIT_CARD,
                    "Bootcamp: " + bc.get().getClassName());
            payment.process();
            payments.add(payment);
            totalPaid += fee;
        }
        return enrolled;
    }

    public boolean removeFromClass(int membershipId, int classId) {
        Optional<Member>       member = findMember(membershipId);
        Optional<BootCampClass> bc    = findClass(classId);

        if (member.isEmpty() || bc.isEmpty()) return false;
        return bc.get().removeMember(member.get());
    }

    public Optional<BootCampClass> findClass(int classId) {
        return classes.stream()
                .filter(c -> c.getClassId() == classId)
                .findFirst();
    }

    public void listAllClasses() {
        if (classes.isEmpty()) { System.out.println("  No classes registered."); return; }
        classes.forEach(c -> System.out.println("  " + c));
    }

    public void printClassRosters() {
        classes.forEach(c -> { c.printRoster(); System.out.println(); });
    }

    // ══════════════════════════════════════════════════════════════════════
    //  BOOKINGS & PAYMENTS
    // ══════════════════════════════════════════════════════════════════════

    public void listAllBookings() {
        if (bookings.isEmpty()) { System.out.println("  No bookings."); return; }
        bookings.forEach(b -> System.out.println("  " + b));
    }

    public void listAllPayments() {
        if (payments.isEmpty()) { System.out.println("  No payments."); return; }
        payments.forEach(p -> System.out.println("  " + p));
        System.out.printf("  ─────────────────────────────────────────%n");
        System.out.printf("  Total Revenue: £%.2f%n", totalPaid);
    }

    private Optional<Payment> findPayment(int paymentId) {
        return payments.stream()
                .filter(p -> p.getPaymentId() == paymentId)
                .findFirst();
    }

    // ══════════════════════════════════════════════════════════════════════
    //  SUMMARY
    // ══════════════════════════════════════════════════════════════════════

    public void printSystemSummary() {
        System.out.println("  ┌─── MyFitness System Summary ─────────────");
        System.out.printf ("  │ Members     : %d%n", members.size());
        System.out.printf ("  │ Staff       : %d (incl. %d instructors)%n",
                staff.size(), instructors.size());
        System.out.printf ("  │ Classes     : %d%n", classes.size());
        System.out.printf ("  │ Bookings    : %d%n", bookings.size());
        System.out.printf ("  │ Payments    : %d | Revenue: £%.2f%n",
                payments.size(), totalPaid);
        System.out.println("  └──────────────────────────────────────────");
    }
}
