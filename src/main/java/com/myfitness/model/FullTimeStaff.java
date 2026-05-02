package com.myfitness.model;

/**
 * Full-time staff member — fixed monthly salary with benefits.
 */
public class FullTimeStaff extends Staff {

    private double monthlySalary;
    private String benefits;

    public FullTimeStaff(int id, String name, String email, String password,
                         int staffId, String role, double monthlySalary, String benefits) {
        super(id, name, email, password, staffId, role);
        this.monthlySalary = monthlySalary;
        this.benefits      = benefits;
    }

    // ── Getters ────────────────────────────────────────────────────────────
    public double getMonthlySalary() { return monthlySalary; }
    public String getBenefits()      { return benefits; }

    // ── Setters ────────────────────────────────────────────────────────────
    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }
    public void setBenefits(String benefits)           { this.benefits      = benefits; }

    // ── Methods ────────────────────────────────────────────────────────────
    public double calculateSalary() {
        System.out.printf("  %s | Monthly Salary: £%.2f%n", getName(), monthlySalary);
        return monthlySalary;
    }

    @Override
    public String toString() {
        return String.format("[FULL-TIME] %s | Salary: £%.2f/mo | Benefits: %s",
                super.toString(), monthlySalary, benefits);
    }
}
