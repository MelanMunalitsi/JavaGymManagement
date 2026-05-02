package com.myfitness.model;

import java.time.LocalDate;

/**
 * Represents a member's booking for a bootcamp class.
 */
public class Booking {

    public enum Status { PENDING, CONFIRMED, CANCELLED }

    private int          bookingId;
    private Member       member;
    private BootCampClass bootcampClass;
    private LocalDate    bookingDate;
    private Status       status;

    public Booking(int bookingId, Member member, BootCampClass bootcampClass) {
        this.bookingId     = bookingId;
        this.member        = member;
        this.bootcampClass = bootcampClass;
        this.bookingDate   = LocalDate.now();
        this.status        = Status.PENDING;
    }

    // Getters
    public int           getBookingId()     { return bookingId; }
    public Member        getMember()        { return member; }
    public BootCampClass getBootcampClass() { return bootcampClass; }
    public LocalDate     getBookingDate()   { return bookingDate; }
    public Status        getStatus()        { return status; }

    // Methods
    public void confirm() {
        status = Status.CONFIRMED;
        System.out.printf("  ✓ Booking #%d confirmed: %s → %s%n",
                bookingId, member.getName(), bootcampClass.getClassName());
    }

    public void cancel() {
        status = Status.CANCELLED;
        bootcampClass.removeMember(member);
        System.out.printf("  ✗ Booking #%d cancelled for %s.%n", bookingId, member.getName());
    }

    @Override
    public String toString() {
        return String.format("Booking #%-4d | %-20s | %-22s | %s | %s",
                bookingId, member.getName(),
                bootcampClass.getClassName(), bookingDate, status);
    }
}
