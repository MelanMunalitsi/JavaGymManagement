package com.myfitness.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Fitness instructor — a staff member who runs bootcamp classes.
 */
public class Instructor extends Staff {

    private String              specialization;
    private List<BootCampClass> assignedClasses;

    public Instructor(int id, String name, String email, String password,
                      int staffId, String specialization) {
        super(id, name, email, password, staffId, "Instructor");
        this.specialization  = specialization;
        this.assignedClasses = new ArrayList<>();
    }

    // ── Getters ────────────────────────────────────────────────────────────
    public String              getSpecialization()  { return specialization; }
    public List<BootCampClass> getAssignedClasses() { return assignedClasses; }

    // ── Setters ────────────────────────────────────────────────────────────
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // ── Methods ────────────────────────────────────────────────────────────
    public void assignClass(BootCampClass bc) {
        assignedClasses.add(bc);
        System.out.printf("  %s assigned to: %s%n", getName(), bc.getClassName());
    }

    public void conductClass() {
        if (assignedClasses.isEmpty()) {
            System.out.printf("  %s has no assigned classes.%n", getName());
        } else {
            assignedClasses.forEach(bc ->
                System.out.printf("  %s is conducting: %s%n", getName(), bc.getClassName()));
        }
    }

    public void markAttendance() {
        System.out.printf("  %s marked attendance for %d class(es).%n",
                getName(), assignedClasses.size());
    }

    @Override
    public String toString() {
        return String.format("[INSTRUCTOR] %s | Specialization: %s | Classes: %d",
                super.toString(), specialization, assignedClasses.size());
    }
}
