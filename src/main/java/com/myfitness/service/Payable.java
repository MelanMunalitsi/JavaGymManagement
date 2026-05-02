package com.myfitness.service;

/**
 * Interface defining payment behaviour for any entity
 * that can process financial transactions in the system.
 */
public interface Payable {

    /**
     * Process a payment for a given amount.
     * @param amount the amount to charge
     * @return true if payment was successful
     */
    boolean processPayment(double amount);

    /**
     * Issue a refund for a previously processed payment.
     * @param paymentId the ID of the payment to refund
     * @return true if refund was successful
     */
    boolean issueRefund(int paymentId);

    /**
     * Get the total amount paid to date.
     * @return total paid
     */
    double getTotalPaid();
}
