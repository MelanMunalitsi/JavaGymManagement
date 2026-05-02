/*public class StudentMember extends Member{
    //Attributes
    private String studentId;
    private String institutionName;
    private double discountRate;

    private static final double Monthly_fee =15.19;
    private static final  int DUrationInDays =274;
    private static final  int DurationInMonths =9;

     //Constructor
    public StudentMember(int id, String name, String email, String password,
                    int membershipId, String dateJoined, String studentId, String institutionName) {
        super(id, name, email, password, membershipId, dateJoined);
        this.studentId       = studentId;
        this.institutionName = institutionName;
        this.discountRate    = 0.20;
    }
    //methods
        public boolean verifyStudent() {
        boolean valid = (studentId != null && !studentId.isEmpty());
        System.out.println("  Student verification ["
                    + getName() + "]: "
                    + (valid ? "PASSED" : "FAILED"));
        return valid;
    }
    
    public double applyDiscount(double originalAmount) {
        double discounted = originalAmount * (1 - discountRate);
        System.out.printf("  Discount (%.0f%%) applied: "
                        + "GBP %.2f -> GBP %.2f%n",
                          discountRate * 100,
                    originalAmount, discounted);
        return discounted;

    }


    
} */
