package com.myfitness.model;

import java.time.LocalDate;

/**
 * Abstract class representing a gym member.
 * Concrete subclasses define membership-specific behaviour.
 */
public abstract class Member extends Person {

    private int       membershipId;
    private LocalDate dateJoined;
    private String    status;
    private double    balance;

    public Member(int id, String name, String email, String password,
                  int membershipId) {
        super(id, name, email, password);
        this.membershipId = membershipId;
        this.dateJoined   = LocalDate.now();
        this.status       = "Active";
        this.balance      = 0.0;
    }

    // ── Abstract ───────────────────────────────────────────────────────────
    public abstract double getMonthlyFee();
    public abstract int    getMonthsRemaining();
    public abstract String getMembershipType();

    // ── Getters ────────────────────────────────────────────────────────────
    public int       getMembershipId()   { return membershipId; }
    public LocalDate getDateJoined()     { return dateJoined; }
    public String    getStatus()         { return status; }
    public double    getBalance()        { return balance; }
    public int       getDaysRemaining()  { return getMonthsRemaining() * 30; }

    // ── Setters ────────────────────────────────────────────────────────────
    public void setStatus(String status)   { this.status  = status; }
    public void setBalance(double balance) { this.balance = balance; }

    // ── Methods ────────────────────────────────────────────────────────────
    public void makePayment(double amount) {
        balance -= amount;
        System.out.printf("  Payment of £%.2f made by %s. Balance: £%.2f%n",
                amount, getName(), balance);
    }

    public void viewMembershipDetails() {
        System.out.println("  ┌─────────────────────────────────────────");
        System.out.printf ("  │ Member       : %s%n", getName());
        System.out.printf ("  │ Type         : %s%n", getMembershipType());
        System.out.printf ("  │ Monthly Fee  : £%.2f%n", getMonthlyFee());
        System.out.printf ("  │ Months Left  : %d months (%d days)%n",
                getMonthsRemaining(), getDaysRemaining());
        System.out.printf ("  │ Status       : %s%n", getStatus());
        System.out.printf ("  │ Joined       : %s%n", dateJoined);
        System.out.println("  └─────────────────────────────────────────");
    }

    @Override
    public String toString() {
        return String.format("[%-12s] %s | Status: %-8s | Months Left: %d",
                getMembershipType(), super.toString(), status, getMonthsRemaining());
    }
}
