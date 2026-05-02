package com.myfitness.service;

/**
 * Abstract class defining bootcamp fee calculation rules.
 *
 * Task 3c requirements:
 *  - Base fee : £35.50 per class per month
 *  - Discount : 7% if a member enrols in 2 or more classes
 *
 * Concrete subclasses must implement calculateFee().
 */
public abstract class BootcampFee {

    public static final double BASE_FEE_PER_CLASS = 35.50;
    public static final double MULTI_CLASS_DISCOUNT = 0.07;   // 7%
    public static final int    DISCOUNT_THRESHOLD   = 2;      // classes

    /**
     * Calculate the total bootcamp fee for the given number of classes.
     * Must be implemented by concrete subclasses.
     *
     * @param numberOfClasses number of bootcamp classes enrolled
     * @return total fee after any applicable discounts
     */
    public abstract double calculateFee(int numberOfClasses);

    /**
     * Display a detailed fee breakdown to the console.
     *
     * @param numberOfClasses number of bootcamp classes enrolled
     */
    public void printFeeBreakdown(int numberOfClasses) {
        double total    = calculateFee(numberOfClasses);
        double subtotal = BASE_FEE_PER_CLASS * numberOfClasses;
        boolean discountApplied = numberOfClasses >= DISCOUNT_THRESHOLD;

        System.out.println("  ┌─── Bootcamp Fee Breakdown ───────────────");
        System.out.printf ("  │ Classes enrolled  : %d%n", numberOfClasses);
        System.out.printf ("  │ Base fee/class    : £%.2f%n", BASE_FEE_PER_CLASS);
        System.out.printf ("  │ Subtotal          : £%.2f%n", subtotal);
        if (discountApplied) {
            System.out.printf("  │ Discount (%.0f%%)    : -£%.2f%n",
                    MULTI_CLASS_DISCOUNT * 100, subtotal - total);
        } else {
            System.out.println("  │ Discount          : None (enrol in 2+ for 7% off)");
        }
        System.out.printf ("  │ TOTAL DUE         : £%.2f%n", total);
        System.out.println("  └──────────────────────────────────────────");
    }
}
