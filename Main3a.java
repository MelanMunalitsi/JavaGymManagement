import java.util.ArrayList;
import java.util.List;


//  ROOT

abstract class Person {
    private int id;
    private String name;
    private String email;
    private String password;

    public Person(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Email: " + email;
    }
}


//  FUNCTIONAL CATEGORIES

class Member extends Person {
    private int membershipId;
    protected int monthsRemaining;

    public Member(int id, String name, String email, String password, int membershipId, int months) {
        super(id, name, email, password);
        this.membershipId = membershipId;
        this.monthsRemaining = months;
    }

    public int getMembershipId() { return membershipId; }
    public int getMonthsRemaining() { return monthsRemaining; }

    @Override
    public String toString() {
        return "[MEMBER] " + super.toString() + " | ID: " + membershipId + " | Left: " + monthsRemaining + "m";
    }
}

class Staff extends Person {
    private int staffId;
    private String role;

    public String getRole() { return role; }

    public Staff(int id, String name, String email, String password, int staffId, String role) {
        super(id, name, email, password);
        this.staffId = staffId;
        this.role = role;
    }

    @Override
    public String toString() {
        return "[STAFF] " + super.toString() + " | Role: " + role;
    }
}


// LEVEL 3: SPECIALIZED ROLES


class StudentMember extends Member {
    public StudentMember(int id, String name, String email, String password, int mId) {
        super(id, name, email, password, mId, 9); // Students always get 9 months
    }
}

class StandardMember extends Member {
    public StandardMember(int id, String name, String email, String password, int mId) {
        super(id, name, email, password, mId, 12); //Standard gets 12 months
    }
}

class PayAsYouGoMember extends Member {
    private int credits;

    public PayAsYouGoMember(int id, String name, String email, String password, int mId) {
        // valid for 1 month or until credits are used
        super(id, name, email, password, mId, 1);
        this.credits = 0;
    }

    public void topUp(int amount) {
        this.credits += amount;
        System.out.println(getName() + " topped up. Total credits: " + credits);
    }
}

class Instructor extends Staff {
    public Instructor(int id, String name, String email, String password, int staffId) {
        super(id, name, email, password, staffId, " Instructor");
    }
}


// SUPPORTING CLASSES (no inheritance)

class BootCampClass {
    private int classId;
    private String className;
    private int instructorId;
    private int capacity;
    private List<Integer> enrolledMemberIds = new ArrayList<>();

    public BootCampClass(int classId, String className, int instructorId, int capacity) {
        this.classId = classId;
        this.className = className;
        this.instructorId = instructorId;
        this.capacity = capacity;
    }

    public boolean addMember(int memberId) {
        if (enrolledMemberIds.size() < capacity) {
            enrolledMemberIds.add(memberId);
            return true;
        }
        return false;
    }

    public String getClassName() { return className; }
}

class Booking {
    private int bookingId;
    private Member member;
    private BootCampClass bootcampClass;
    private String status = "Pending";

    public Booking(int bookingId, Member member, BootCampClass bootcampClass) {
        this.bookingId = bookingId;
        this.member = member;
        this.bootcampClass = bootcampClass;
    }
    public String getStatus() {
    return status;
    }

    public void confirm() {
        this.status = "Confirmed";
        System.out.println("Booking confirmed for " + member.getName());
    }
}

class Payment {
    private int paymentId;
    private double amount;
    private String status = "Pending";
    public String getStatus() {
    return status;
    }

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public void process() {
        this.status = "Completed";
        System.out.println("Payment of £" + amount + " successful.");
    }
}