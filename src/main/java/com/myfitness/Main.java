package com.myfitness;

import com.myfitness.model.*;
import com.myfitness.service.GymManager;

/**
 * MyFitness Gym Management System
 * Entry point — demonstrates all assignment requirements:
 *
 *  Task 2  : Base class instantiation and display
 *  Task 3a : Full inheritance hierarchy in action
 *  Task 3b : ArrayList-based management of members, staff, bootcamp classes
 *  Task 3c : Abstract BootcampFee with 7% multi-class discount
 */
public class Main {

    private static final GymManager gym = new GymManager();

    public static void main(String[] args) {

        banner("MyFitness Gym Management System");

        task2_BaseClasses();
        task3a_InheritanceHierarchy();
        task3b_GymOperations();
        task3c_BootcampFeeCalculation();

        section("SYSTEM SUMMARY");
        gym.printSystemSummary();

        banner("End of Demonstration");
    }

    // 
    //  TASK 2 — Base class instantiation & getters/setters
    // 
    private static void task2_BaseClasses() {
        section("TASK 2 — Base Classes");

        // Person is abstract so we instantiate via a concrete subclass
        System.out.println("▶ Person (via StandardMember)");
        StandardMember p = new StandardMember(1, "Alice Johnson",
                "alice@email.com", "pass123", 1001);
        System.out.println("  " + p);
        System.out.println("  Login (correct):   " + p.login("alice@email.com", "pass123"));
        System.out.println("  Login (wrong pwd): " + p.login("alice@email.com", "wrongpass"));
        p.updateProfile("Alice M. Johnson", "alice.m@email.com");
        System.out.println("  After profile update: " + p.getName() + " / " + p.getEmail());

        // Member base behaviour
        System.out.println("\n▶ Member base behaviour");
        p.viewMembershipDetails();

        // Staff base behaviour
        System.out.println("\n▶ Staff base behaviour");
        Staff receptionist = new Staff(2, "Bob Smith", "bob@gym.com", "pass",
                201, "Receptionist");
        System.out.println("  " + receptionist);
        receptionist.addShift("Mon-Fri 08:00-16:00");
        receptionist.addShift("Sat 09:00-13:00");
        receptionist.viewSchedule();

        // Payment base behaviour
        System.out.println("\n▶ Payment base behaviour");
        Payment pay = new Payment(5001, p, 20.99,
                Payment.Method.DEBIT_CARD, "Monthly Membership Fee");
        System.out.println("  Initial status : " + pay.getStatus());
        pay.process();
        System.out.println("  After process  : " + pay.getStatus());
        pay.refund();
        System.out.println("  After refund   : " + pay.getStatus());
    }

    // 
    //  TASK 3a — Full inheritance hierarchy
    // 
    private static void task3a_InheritanceHierarchy() {
        section("TASK 3a — Inheritance Hierarchy");

        // Member subtypes
        System.out.println("▶ StudentMember");
        StudentMember student = new StudentMember(10, "Zara Ahmed",
                "zara@uni.ac.uk", "zara99", 2001,
                "STU-48291", "University of London");
        student.verifyStudent();
        student.applyDiscount(35.50);
        student.viewMembershipDetails();

        System.out.println("\n▶ StandardMember");
        StandardMember standard = new StandardMember(11, "David Osei",
                "david@email.com", "david123", 2002);
        standard.earnPoints(150);
        standard.redeemPoints(50);
        standard.freezeMembership();
        standard.freezeMembership(); // second attempt — should fail
        standard.useGuestPass();
        standard.viewMembershipDetails();

        System.out.println("\n▶ PayAsYouGoMember");
        PayAsYouGoMember payg = new PayAsYouGoMember(12, "Sam Kofi",
                "sam@email.com", "sampass", 2003);
        payg.topUp(5);
        payg.useCredit();
        payg.useCredit();
        payg.viewMembershipDetails();

        // Staff subtypes
        System.out.println("\n▶ FullTimeStaff");
        FullTimeStaff ft = new FullTimeStaff(20, "Linda Torres",
                "linda@gym.com", "linda1", 301, "Manager",
                2800.00, "Health Insurance, 28 days holiday");
        ft.addShift("Mon-Fri 06:00-14:00");
        ft.calculateSalary();
        System.out.println("  " + ft);

        System.out.println("\n▶ PartTimeStaff");
        PartTimeStaff pt = new PartTimeStaff(21, "James Mwangi",
                "james@gym.com", "james1", 302, "Cleaner",
                12.50, 20);
        pt.logHours(8);
        pt.calculatePay();
        System.out.println("  " + pt);

        System.out.println("\n▶ Instructor");
        Instructor instructor = new Instructor(22, "Priya Sharma",
                "priya@gym.com", "priya1", 303, "Fat Burn & Cardio");
        System.out.println("  " + instructor);
    }

    // 
    //  TASK 3b — ArrayList-based operations with dummy data
    // 
    private static void task3b_GymOperations() {
        section("TASK 3b — Gym Operations (ArrayLists)");

        // Seed: Instructors
        System.out.println("▶ Adding Instructors");
        Instructor i1 = new Instructor(30, "Priya Sharma",   "priya@gym.com",  "p1", 401, "Fat Burn & Cardio");
        Instructor i2 = new Instructor(31, "Carlos Diaz",    "carlos@gym.com", "p2", 402, "Fitness & Endurance");
        Instructor i3 = new Instructor(32, "Amina Yusuf",    "amina@gym.com",  "p3", 403, "Full Body Strength");
        gym.addInstructor(i1);
        gym.addInstructor(i2);
        gym.addInstructor(i3);

        // Seed: Full-time staff
        System.out.println("\n▶ Adding Full-Time Staff");
        gym.addStaff(new FullTimeStaff(33, "Linda Torres",   "linda@gym.com",   "l1", 501, "Manager",      2800.00, "Health Insurance"));
        gym.addStaff(new FullTimeStaff(34, "Owen Richards",  "owen@gym.com",    "l2", 502, "Supervisor",   2400.00, "Pension, 25 days"));
        gym.addStaff(new FullTimeStaff(35, "Grace Muthoni",  "grace@gym.com",   "l3", 503, "Front Desk",   2100.00, "Health Insurance"));
        gym.addStaff(new FullTimeStaff(36, "Tom Adekunle",   "tom@gym.com",     "l4", 504, "Security",     2200.00, "Pension"));
        gym.addStaff(new FullTimeStaff(37, "Nina Patel",     "nina@gym.com",    "l5", 505, "Trainer",      2300.00, "Health Insurance"));

        // Seed: Part-time staff
        System.out.println("\n▶ Adding Part-Time Staff");
        gym.addStaff(new PartTimeStaff(38, "James Mwangi",  "james@gym.com",  "pt1", 601, "Cleaner",    12.50, 20));
        gym.addStaff(new PartTimeStaff(39, "Sara Bloom",    "sara@gym.com",   "pt2", 602, "Receptionist", 13.00, 16));
        gym.addStaff(new PartTimeStaff(40, "Felix Ono",     "felix@gym.com",  "pt3", 603, "Lifeguard",  13.50, 24));
        gym.addStaff(new PartTimeStaff(41, "Yemi Adeyemi",  "yemi@gym.com",   "pt4", 604, "Trainer",    14.00, 12));

        // Seed: Bootcamp classes
        System.out.println("\n▶ Setting Up Bootcamp Classes");
        BootCampClass fatBurn     = new BootCampClass(701, "Fat Burn",            i1, 15);
        BootCampClass fitnessEnd  = new BootCampClass(702, "Fitness & Endurance", i2, 15);
        BootCampClass fullBody    = new BootCampClass(703, "Full Body",           i3, 15);
        gym.addClass(fatBurn);
        gym.addClass(fitnessEnd);
        gym.addClass(fullBody);

        i1.assignClass(fatBurn);
        i2.assignClass(fitnessEnd);
        i3.assignClass(fullBody);

        // Seed: Members
        System.out.println("\n▶ Registering Members");
        StudentMember    m1 = new StudentMember(50,    "Zara Ahmed",     "zara@uni.ac.uk",   "z1", 1001, "STU-001", "City University");
        StandardMember   m2 = new StandardMember(51,   "David Osei",     "david@email.com",  "d1", 1002);
        StandardMember   m3 = new StandardMember(52,   "Rachel Kim",     "rachel@email.com", "r1", 1003);
        PayAsYouGoMember m4 = new PayAsYouGoMember(53, "Sam Kofi",       "sam@email.com",    "s1", 1004);
        StudentMember    m5 = new StudentMember(54,    "Fatima Hassan",  "fatima@uni.ac.uk", "f1", 1005, "STU-002", "Kings College");
        StandardMember   m6 = new StandardMember(55,   "Ethan Brooks",   "ethan@email.com",  "e1", 1006);

        gym.addMember(m1); gym.addMember(m2); gym.addMember(m3);
        gym.addMember(m4); gym.addMember(m5); gym.addMember(m6);

        m4.topUp(10);

        // Display all members
        System.out.println("\n▶ All Registered Members");
        gym.listAllMembers();

        // Display all staff
        System.out.println("\n▶ All Staff");
        gym.listAllStaff();

        // Enrol members in classes
        System.out.println("\n▶ Enrolling Members in Bootcamp Classes");
        gym.enrolMemberInClass(1001, 701);  // Zara → Fat Burn
        gym.enrolMemberInClass(1001, 702);  // Zara → Fitness & Endurance (triggers 7% discount)
        gym.enrolMemberInClass(1002, 701);  // David → Fat Burn
        gym.enrolMemberInClass(1003, 703);  // Rachel → Full Body
        gym.enrolMemberInClass(1005, 701);  // Fatima → Fat Burn
        gym.enrolMemberInClass(1005, 703);  // Fatima → Full Body (triggers 7% discount)
        gym.enrolMemberInClass(1006, 702);  // Ethan → Fitness & Endurance
        gym.enrolMemberInClass(9999, 701);  // ✗ Non-existent member

        // Class rosters
        System.out.println("\n▶ Bootcamp Class Rosters");
        gym.printClassRosters();

        // Remove a member from class
        System.out.println("▶ Removing David from Fat Burn");
        gym.removeFromClass(1002, 701);

        // Membership details
        System.out.println("\n▶ Membership Details");
        gym.findMember(1001).ifPresent(Member::viewMembershipDetails);
        gym.findMember(1002).ifPresent(Member::viewMembershipDetails);
        gym.findMember(1004).ifPresent(Member::viewMembershipDetails);

        // Bookings
        System.out.println("▶ All Bookings");
        gym.listAllBookings();

        // Payments
        System.out.println("\n▶ All Payments");
        gym.listAllPayments();
    }

    // 
    //  TASK 3c — Abstract BootcampFee with discount logic
    // 
    private static void task3c_BootcampFeeCalculation() {
        section("TASK 3c — Bootcamp Fee Calculation (Abstract Class)");

        System.out.println("Scenario: Member enrolling in 1 class (no discount)");
        gym.printFeeBreakdown(1);

        System.out.println("\nScenario: Member enrolling in 2 classes (7% discount applies)");
        gym.printFeeBreakdown(2);

        System.out.println("\nScenario: Member enrolling in 3 classes (7% discount applies)");
        gym.printFeeBreakdown(3);

        System.out.println("\nDirect fee calculations:");
        System.out.printf("  1 class  → £%.2f%n", gym.calculateFee(1));
        System.out.printf("  2 classes → £%.2f (was £%.2f, saving £%.2f)%n",
                gym.calculateFee(2),
                GymManager.BASE_FEE_PER_CLASS * 2,
                (GymManager.BASE_FEE_PER_CLASS * 2) - gym.calculateFee(2));
        System.out.printf("  3 classes → £%.2f (was £%.2f, saving £%.2f)%n",
                gym.calculateFee(3),
                GymManager.BASE_FEE_PER_CLASS * 3,
                (GymManager.BASE_FEE_PER_CLASS * 3) - gym.calculateFee(3));
    }

    // 
    //  Formatting helpers
    // 
    private static void banner(String title) {
        String line = "═".repeat(60);
        System.out.println("\n" + line);
        System.out.printf("  %s%n", title);
        System.out.println(line + "\n");
    }

    private static void section(String title) {
        System.out.printf("%n┌─ %s %s%n%n", title, "─".repeat(Math.max(0, 54 - title.length())));
    }
}
