package com.myfitness.model;

/**
 * Part-time staff member — paid by hourly rate.
 */
public class PartTimeStaff extends Staff {

    private double hourlyRate;
    private int    hoursWorked;

    public PartTimeStaff(int id, String name, String email, String password,
                         int staffId, String role, double hourlyRate, int hoursWorked) {
        super(id, name, email, password, staffId, role);
        this.hourlyRate   = hourlyRate;
        this.hoursWorked  = hoursWorked;
    }

    // Getters
    public double getHourlyRate()  { return hourlyRate; }
    public int    getHoursWorked() { return hoursWorked; }

    // Setters
    public void setHourlyRate(double hourlyRate)  { this.hourlyRate  = hourlyRate; }
    public void setHoursWorked(int hoursWorked)   { this.hoursWorked = hoursWorked; }

    // Methods
    public double calculatePay() {
        double pay = hourlyRate * hoursWorked;
        System.out.printf("  %s | £%.2f/hr × %d hrs = £%.2f%n",
                getName(), hourlyRate, hoursWorked, pay);
        return pay;
    }

    public void logHours(int additionalHours) {
        hoursWorked += additionalHours;
        System.out.printf("  %s logged +%d hrs. Total: %d hrs%n",
                getName(), additionalHours, hoursWorked);
    }

    @Override
    public String toString() {
        return String.format("[PART-TIME] %s | Rate: £%.2f/hr | Hours: %d | Pay: £%.2f",
                super.toString(), hourlyRate, hoursWorked, hourlyRate * hoursWorked);
    }
}
