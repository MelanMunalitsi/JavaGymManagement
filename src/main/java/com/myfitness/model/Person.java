package com.myfitness.model;

/**
 * Abstract base class representing any person in the MyFitness system.
 * All members and staff inherit from this class.
 */
public abstract class Person {

    private int    id;
    private String name;
    private String email;
    private String password;

    public Person(int id, String name, String email, String password) {
        this.id       = id;
        this.name     = name;
        this.email    = email;
        this.password = password;
    }

    // ── Getters ────────────────────────────────────────────────────────────
    public int    getId()    { return id; }
    public String getName()  { return name; }
    public String getEmail() { return email; }

    // ── Setters ────────────────────────────────────────────────────────────
    public void setName(String name)        { this.name     = name; }
    public void setEmail(String email)      { this.email    = email; }
    public void setPassword(String password){ this.password = password; }

    // ── Methods ────────────────────────────────────────────────────────────
    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
        System.out.println(name + " has logged out.");
    }

    public void updateProfile(String name, String email) {
        this.name  = name;
        this.email = email;
        System.out.println("Profile updated for: " + name);
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Name: %-20s | Email: %s", id, name, email);
    }
}
