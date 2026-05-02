package com.myfitness.model;

/**
 * Pay-as-you-go membership — £4.95 per visit, 30 days to use credits.
 */
public class PayAsYouGoMember extends Member {

    private static final double COST_PER_VISIT  = 4.95;
    private static final int    DURATION_MONTHS = 1;

    private int credits;

    public PayAsYouGoMember(int id, String name, String email, String password,
                            int membershipId) {
        super(id, name, email, password, membershipId);
        this.credits = 0;
    }

    // ── Getters ────────────────────────────────────────────────────────────
    public int    getCredits()       { return credits; }
    public double getCostPerVisit()  { return COST_PER_VISIT; }

    // ── Abstract implementations ───────────────────────────────────────────
    @Override public double getMonthlyFee()      { return COST_PER_VISIT; }
    @Override public int    getMonthsRemaining() { return DURATION_MONTHS; }
    @Override public String getMembershipType()  { return "Pay-As-You-Go"; }

    // ── Methods ────────────────────────────────────────────────────────────
    public void topUp(int visits) {
        if (visits > 0) {
            credits += visits;
            System.out.printf("  %s topped up %d visit(s). Total credits: %d%n",
                    getName(), visits, credits);
        }
    }

    public boolean useCredit() {
        if (credits > 0) {
            credits--;
            System.out.printf("  1 credit used. Remaining credits: %d%n", credits);
            return true;
        }
        System.out.println("  No credits remaining. Please top up.");
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" | Credits: %d | Cost/visit: £%.2f", credits, COST_PER_VISIT);
    }
}
