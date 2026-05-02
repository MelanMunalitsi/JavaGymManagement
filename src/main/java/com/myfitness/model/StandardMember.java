package com.myfitness.model;

/**
 * Standard membership — £20.99/month + £5 joining fee, 12 months, 24/7 access.
 * Can freeze once, bring guests up to 4x/month.
 */
public class StandardMember extends Member {

    private static final double MONTHLY_FEE     = 20.99;
    private static final double JOINING_FEE     = 5.00;
    private static final int    DURATION_MONTHS = 12;
    private static final int    MAX_GUESTS      = 4;

    private int     loyaltyPoints;
    private boolean frozen;
    private boolean freezeUsed;
    private int     guestPassesThisMonth;

    public StandardMember(int id, String name, String email, String password,
                          int membershipId) {
        super(id, name, email, password, membershipId);
        this.loyaltyPoints        = 0;
        this.frozen               = false;
        this.freezeUsed           = false;
        this.guestPassesThisMonth = 0;
    }

    // Getters
    public int     getLoyaltyPoints()        { return loyaltyPoints; }
    public boolean isFrozen()                { return frozen; }
    public int     getGuestPassesThisMonth() { return guestPassesThisMonth; }

    // Abstract implementations
    @Override public double getMonthlyFee()      { return MONTHLY_FEE; }
    @Override public int    getMonthsRemaining() { return DURATION_MONTHS; }
    @Override public String getMembershipType()  { return "Standard"; }

    // Methods
    public void earnPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
            System.out.printf("  %s earned %d points. Total: %d%n",
                    getName(), points, loyaltyPoints);
        }
    }

    public boolean redeemPoints(int points) {
        if (loyaltyPoints >= points) {
            loyaltyPoints -= points;
            System.out.printf("  %d points redeemed. Remaining: %d%n", points, loyaltyPoints);
            return true;
        }
        System.out.println("  Insufficient loyalty points.");
        return false;
    }

    public boolean freezeMembership() {
        if (!freezeUsed) {
            frozen     = true;
            freezeUsed = true;
            System.out.println("  Membership frozen successfully.");
            return true;
        }
        System.out.println("  Free freeze already used.");
        return false;
    }

    public boolean useGuestPass() {
        if (guestPassesThisMonth < MAX_GUESTS) {
            guestPassesThisMonth++;
            System.out.printf("  Guest pass used. Remaining this month: %d%n",
                    MAX_GUESTS - guestPassesThisMonth);
            return true;
        }
        System.out.println("  Monthly guest pass limit reached (max 4).");
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" | Points: %d | Frozen: %s", loyaltyPoints, frozen);
    }
}
