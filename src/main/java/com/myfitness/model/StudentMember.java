package com.myfitness.model;

/**
 * Student membership — 20% discount, valid for 9 months.
 * Requires a valid student ID for verification.
 */
public class StudentMember extends Member {

    private static final double MONTHLY_FEE      = 15.91;
    private static final double DISCOUNT_RATE    = 0.20;
    private static final int    DURATION_MONTHS  = 9;

    private String  studentId;
    private String  institution;
    private boolean verified;

    public StudentMember(int id, String name, String email, String password,
                         int membershipId, String studentId, String institution) {
        super(id, name, email, password, membershipId);
        this.studentId   = studentId;
        this.institution = institution;
        this.verified    = false;
    }

    // Getters
    public String  getStudentId()   { return studentId; }
    public String  getInstitution() { return institution; }
    public boolean isVerified()     { return verified; }

    // Setters
    public void setStudentId(String studentId)     { this.studentId   = studentId; }
    public void setInstitution(String institution) { this.institution = institution; }

    // Abstract implementations
    @Override public double getMonthlyFee()      { return MONTHLY_FEE; }
    @Override public int    getMonthsRemaining() { return DURATION_MONTHS; }
    @Override public String getMembershipType()  { return "Student"; }

    // Methods
    public boolean verifyStudent() {
        verified = studentId != null && !studentId.isBlank();
        System.out.printf("  Student verification [%s]: %s%n",
                getName(), verified ? "PASSED ✓" : "FAILED ✗");
        return verified;
    }

    public double applyDiscount(double originalAmount) {
        double discounted = originalAmount * (1 - DISCOUNT_RATE);
        System.out.printf("  Discount (%.0f%%) applied: £%.2f → £%.2f%n",
                DISCOUNT_RATE * 100, originalAmount, discounted);
        return discounted;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" | StudentID: %s | Institution: %s", studentId, institution);
    }
}
