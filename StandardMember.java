/*public class StandardMember extends Member {

    // attributes
    private int loyaltyPoints;
    private boolean frozen;
    private boolean freezeUsed;
    private int guestPassesThisMonth;

    // constants
    private static final double MONTHLY_FEE    = 20.99;
    private static final double JOINING_FEE    = 5.00;
    private static final int    MAX_GUESTS     = 4;
    private static final int    DURATION_DAYS  = 365;
    private static final int    DURATION_MONTHS = 12;

    public StandardMember(int id, String name, String email, String password,
            int membershipId, String dateJoined) {

        super(id, name, email, password, membershipId, dateJoined);

        this.loyaltyPoints = 0;
        this.frozen = false;
        this.freezeUsed = false;
        this.guestPassesThisMonth = 0;
    }

    // METHODS
    

    public void earnPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
            System.out.println(getName() + " earned " + points  + " points. Total: " + loyaltyPoints);
        }
    }

    public boolean redeemPoints(int points) {
        if (loyaltyPoints >= points) {
            loyaltyPoints -= points;
            System.out.println(points + " points redeemed successfully.");
            return true;
        }
        System.out.println("Insufficient loyalty points.");
        return false;
    }

    public void freezeMembership() {
        if (!freezeUsed) {
            frozen = true;
            freezeUsed = true;
            System.out.println("Membership frozen successfully.");
        } else {
            System.out.println("Free freeze already used.");
        }
    }

    public boolean useGuestPass() {
        if (guestPassesThisMonth < MAX_GUESTS) {
            guestPassesThisMonth++;
            System.out.println("Guest pass used. Remaining: "
                + (MAX_GUESTS - guestPassesThisMonth));
            return true;
        }
        System.out.println("Guest pass limit reached.");
        return false;
    }
} */