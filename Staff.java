/* import java.util.ArrayList;
import java.util.List;
public class Staff extends Person {

    // -- Attributes (from UML)
    private int          staffId;
    private String       role;
    private List<String> schedule;  // shift entries e.g. "Mon-Fri 06:00-14:00"
    // -- Constructor
    public Staff(int id, String name, String email, String password,
        int staffId, String role) {

        super(id, name, email, password);
        this.staffId = staffId;
        this.role = role;
        this.schedule = new ArrayList<>();
    }

    // - Getters
    public int           getStaffId()   { return staffId; }
    public String        getRole()      { return role; }
    public List<String>  getSchedule()  { return schedule; }

    //  Setters
    public void setRole(String role) { this.role = role; }

    // Methods
    public List<String> viewSchedule() {
        System.out.println("  Schedule for " + getName() + ":");
        if (schedule.isEmpty()) {
            System.out.println("    No shifts scheduled.");
        } else {
            for (String s : schedule) System.out.println("    " + s);
        }
        return schedule;
    }
    public void updateSchedule(String shift) {
        schedule.add(shift);
        System.out.println("  Schedule updated ["
            + getName() + "]: " + shift);
    }
    @Override
    public String toString() {
        return super.toString()
        + " | StaffID: " + staffId
        + " | Role: "    + role;

    }
}
*/