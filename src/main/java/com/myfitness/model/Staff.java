package com.myfitness.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a gym staff member.
 * Extended by FullTimeStaff, PartTimeStaff, and Instructor.
 */
public class Staff extends Person {

    private int          staffId;
    private String       role;
    private List<String> schedule;

    public Staff(int id, String name, String email, String password,
                 int staffId, String role) {
        super(id, name, email, password);
        this.staffId  = staffId;
        this.role     = role;
        this.schedule = new ArrayList<>();
    }

    // Getters
    public int          getStaffId()  { return staffId; }
    public String       getRole()     { return role; }
    public List<String> getSchedule() { return schedule; }

    // Setters
    public void setRole(String role) { this.role = role; }

    // Methods
    public void addShift(String shift) {
        schedule.add(shift);
        System.out.printf("  Shift added for %s: %s%n", getName(), shift);
    }

    public void viewSchedule() {
        System.out.printf("  Schedule for %s:%n", getName());
        if (schedule.isEmpty()) {
            System.out.println("    No shifts scheduled.");
        } else {
            schedule.forEach(s -> System.out.println("    → " + s));
        }
    }

    @Override
    public String toString() {
        return String.format("[%-12s] %s | StaffID: %d",
                role, super.toString(), staffId);
    }
}
