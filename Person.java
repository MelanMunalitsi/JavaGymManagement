/*public  class Person {
    private int id;
    protected String name;
    private String email;
    private String password;

    public Person(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
public boolean login(String email, String password) {
    if (email != null && password != null &&
        this.email.equals(email) && this.password.equals(password)) {
        return true;
    } else {
        return false;
    }
}

    public void logout() {
        System.out.println(name + " logged out.");
    }

    public void updateProfile(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
*/