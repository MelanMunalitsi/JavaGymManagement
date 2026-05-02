package com.myfitness.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents one of the three MyFitness bootcamp classes:
 * Fat Burn, Fitness & Endurance, Full Body.
 * Duration: 30 days per class.
 */
public class BootCampClass {

    private static final int DURATION_DAYS = 30;

    private int          classId;
    private String       className;
    private Instructor   instructor;
    private int          capacity;
    private List<Member> enrolledMembers;

    public BootCampClass(int classId, String className, Instructor instructor, int capacity) {
        this.classId         = classId;
        this.className       = className;
        this.instructor      = instructor;
        this.capacity        = capacity;
        this.enrolledMembers = new ArrayList<>();
    }

    // ── Getters ────────────────────────────────────────────────────────────
    public int        getClassId()         { return classId; }
    public String     getClassName()       { return className; }
    public Instructor getInstructor()      { return instructor; }
    public int        getCapacity()        { return capacity; }
    public int        getEnrolledCount()   { return enrolledMembers.size(); }
    public int        getDurationDays()    { return DURATION_DAYS; }
    public List<Member> getEnrolledMembers() { return enrolledMembers; }

    // ── Setters ────────────────────────────────────────────────────────────
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public void setCapacity(int capacity)            { this.capacity   = capacity; }

    // ── Methods ────────────────────────────────────────────────────────────
    public boolean isAvailable() {
        return enrolledMembers.size() < capacity;
    }

    public boolean enrolMember(Member member) {
        if (!isAvailable()) {
            System.out.printf("  ✗ %s is full. Cannot enrol %s.%n", className, member.getName());
            return false;
        }
        if (enrolledMembers.contains(member)) {
            System.out.printf("  ✗ %s is already enrolled in %s.%n", member.getName(), className);
            return false;
        }
        enrolledMembers.add(member);
        System.out.printf("  ✓ %s enrolled in %s.%n", member.getName(), className);
        return true;
    }

    public boolean removeMember(Member member) {
        if (enrolledMembers.remove(member)) {
            System.out.printf("  ✓ %s removed from %s.%n", member.getName(), className);
            return true;
        }
        System.out.printf("  ✗ %s was not found in %s.%n", member.getName(), className);
        return false;
    }

    public void printRoster() {
        System.out.printf("  ── %s Roster (%d/%d) ──%n",
                className, enrolledMembers.size(), capacity);
        System.out.printf("     Instructor : %s%n", instructor.getName());
        System.out.printf("     Duration   : %d days%n", DURATION_DAYS);
        if (enrolledMembers.isEmpty()) {
            System.out.println("     No members enrolled.");
        } else {
            for (int i = 0; i < enrolledMembers.size(); i++) {
                System.out.printf("     %2d. %s%n", i + 1, enrolledMembers.get(i).getName());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("BootCamp[%d] %-22s | Instructor: %-18s | Enrolled: %d/%d",
                classId, className, instructor.getName(), enrolledMembers.size(), capacity);
    }
}
