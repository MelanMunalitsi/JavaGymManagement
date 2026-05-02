/* public class Member extends Person {

    private int membershipId;
    private String dateJoined;
    private String status;
    private double balance;

    public Member(int id, String name, String email, String password,
            int membershipId, String dateJoined ) {

        super(id, name, email, password);
        this.membershipId = membershipId;
        this.dateJoined = dateJoined;
        this.status = "Active";
        this.balance = 0.0;
    }

    public String getName() {
        return super.getName();
    }

    public int getMembershipId() { return membershipId; }
    public String getDateJoined() { return dateJoined; }
    public String getStatus() { return status; }
    public double getBalance() { return balance; }

    public void setStatus(String status) { this.status = status; }
    public void setBalance(double balance) { this.balance = balance; }

    public void bookClass() {
        System.out.println(getName() + " booked a class.");
    }

    public void cancelBooking() {
        System.out.println(getName() + " cancelled a booking.");
    }

    public void viewBookings() {
        System.out.println(getName() + " is viewing bookings.");
    }

    public void makePayment(double amount) {
        balance -= amount;
        System.out.println("Payment of " + amount + " made.");
    }

    public int getDaysRemaining() {
        return 270;
    }

    public int getMonthsRemaining() {
        return 9;
    }

    @Override
    public String toString() {
        return "[MEMBER] " + getName()
            + " | MembershipID: " + membershipId
            + " | Status: " + status;
            
    }
}*/