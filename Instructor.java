/*import java.util.ArrayList;
import java.util.List;

public class Instructor extends Staff{
    //attributes
    private String              specialization;
    private List<BootCampClass> assignedClasses;
    //  Constructor
    public Instructor(int id, String name, String email, String password,
            int staffId, String specialization) {
        super(id, name, email, password, staffId, "Instructor");
        this.specialization  = specialization;
        this.assignedClasses = new ArrayList<>();
    }
// Getters
    public String              getSpecialization()  { return specialization; }
    public List<BootCampClass> getAssignedClasses() { return assignedClasses; }

    // Setters
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
//methods
 // Methods
    public void assignClass(BootCampClass bc) {
    assignedClasses.add(bc);

    System.out.println("  " + getName()
            + " assigned to class: " + bc.getClassName());
}

    public void conductClass() {
        if (assignedClasses.isEmpty()) {
            System.out.println("  " + getName()
                + " has no assigned classes.");
        } else {
            for (BootCampClass bc : assignedClasses) {
                System.out.println("  " + getName()
                + " is conducting: " + bc.getClassName());
            }
        }
    }
    public void markAttendance() {
        System.out.println("  " + getName()
            + " marked attendance for "
            + assignedClasses.size() + " class(es).");
    }
    @Override
    public String toString() {
        return "[INSTRUCTOR]  " + super.toString()
            + " | Specialization: " + specialization
            + " | Assigned classes: " + assignedClasses.size();
    }
} */
