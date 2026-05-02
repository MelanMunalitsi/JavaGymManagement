/*import java.time.LocalDate;

public class Booking {
    // attributes
    private int bookingId;
    private Member member;
    private BootCampClass bootcampClass;
    private String bookingDate;
    private String status;

    // constructor
    public Booking(int bookingId, Member member, BootCampClass bootcampClass) {
        this.bookingId = bookingId;
        this.member = member;
        this.bootcampClass = bootcampClass;
        this.bookingDate = LocalDate.now().toString();
        this.status = "Pending";
    }

    // getters
    public int getBookingId() { return bookingId; }
    public Member getMember() { return member; }
    public BootCampClass getBootcampClass() { return bootcampClass; }
    public String getBookingDate() { return bookingDate; }
    public String getStatus() { return status; }

    // methods
    public void confirm() {
        status = "Confirmed";
        System.out.println("  [CONFIRMED] Booking #" + bookingId
                + ": " + member.getName()
                + " -> " + bootcampClass.getClassName());
    }

    public void cancel() {
        status = "Cancelled";
        System.out.println("  [CANCELLED] Booking #" + bookingId);
    }

    @Override
    public String toString() {
        return String.format(
            "Booking #%-2d | %-16s | %-22s | %s | %s",
            bookingId, member.getName(),
            bootcampClass.getClassName(), bookingDate, status);
    }
}
    */