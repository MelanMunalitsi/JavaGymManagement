package com.myfitness.model;

import java.time.LocalDate;

/**
 * Represents a payment transaction in the MyFitness system.
 */
public class Payment {

    public enum Status { PENDING, COMPLETED, REFUNDED, FAILED }

    public enum Method { CREDIT_CARD, DEBIT_CARD, BANK_TRANSFER, CASH }

    private int       paymentId;
    private Member    member;
    private double    amount;
    private Method    method;
    private LocalDate date;
    private Status    status;
    private String    description;

    public Payment(int paymentId, Member member, double amount, Method method, String description) {
        this.paymentId   = paymentId;
        this.member      = member;
        this.amount      = amount;
        this.method      = method;
        this.date        = LocalDate.now();
        this.status      = Status.PENDING;
        this.description = description;
    }

    // ── Getters ────────────────────────────────────────────────────────────
    public int       getPaymentId()   { return paymentId; }
    public Member    getMember()      { return member; }
    public double    getAmount()      { return amount; }
    public Method    getMethod()      { return method; }
    public LocalDate getDate()        { return date; }
    public Status    getStatus()      { return status; }
    public String    getDescription() { return description; }

    // ── Methods ────────────────────────────────────────────────────────────
    public boolean process() {
        if (amount <= 0) {
            status = Status.FAILED;
            System.out.println("  ✗ Payment failed: invalid amount.");
            return false;
        }
        status = Status.COMPLETED;
        member.makePayment(amount);
        System.out.printf("  ✓ Payment #%d processed: £%.2f via %s (%s)%n",
                paymentId, amount, method, description);
        return true;
    }

    public boolean refund() {
        if (status != Status.COMPLETED) {
            System.out.println("  ✗ Only completed payments can be refunded.");
            return false;
        }
        status = Status.REFUNDED;
        System.out.printf("  ✓ Payment #%d refunded: £%.2f to %s%n",
                paymentId, amount, member.getName());
        return true;
    }

    @Override
    public String toString() {
        return String.format("Payment #%-4d | %-20s | £%7.2f | %-14s | %s | %s | %s",
                paymentId, member.getName(), amount, method, date, status, description);
    }
}
