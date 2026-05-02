/*import java.util.ArrayList;
import java.util.List;

public class BootCampClass {
    private int classId;
    private String className;
    private int instructorId;
    private int capacity;
    private List<Integer> enrolledMemberIds; // Using Integers for Task 2 decoupling

    public BootCampClass(int classId, String className, int instructorId, int capacity) {
        this.classId = classId;
        this.className = className;
        this.instructorId = instructorId;
        this.capacity = capacity;
        this.enrolledMemberIds = new ArrayList<>();
    }

    // Returns true if member was added, false if class is full
    public boolean addMember(int memberId) {
        if (enrolledMemberIds.size() < capacity) {
            enrolledMemberIds.add(memberId);
            return true;
        }
        return false;
    }

    public void removeMember(int memberId) {
        // Correctly removes the Integer object rather than using the index
        enrolledMemberIds.remove(Integer.valueOf(memberId));
    }

    public boolean checkAvailability() {
        return enrolledMemberIds.size() < capacity;
    }

    // Getters
    public String getClassName() { return className; }
} */