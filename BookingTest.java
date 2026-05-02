/*public class BookingTest {
    public static void main(String[] args) {
        System.out.println("========== MYFITNESS: INDEPENDENT BOOKING TEST ==========");

        /*
        1. Setup: Create a new Booking object.
        To eliminate inheritance/dependency in Task 2, we use IDs
        instead of full Member/Staff objects.
        
        int dummyMemberId = 1;
        int dummyClassId = 201;
        String dateOfClass = "2026-06-01";
        
        // Testing the standalone logic of the Booking constructor
        Booking session = new Booking(9001, dummyMemberId, dummyClassId, dateOfClass);

        // 2. Verify Initial State
        System.out.println("\n[TEST 1] Verifying Booking Creation:");
        System.out.println("Booking ID: " + session.getBookingId());
        System.out.println("Scheduled for Member ID: " + dummyMemberId);
        System.out.println("Status: " + session.getStatus()); // Should be "Pending"

        // 3. Test Confirm Method (UML Method)
        System.out.println("\n[TEST 2] Confirming Booking:");
        session.confirm();
        System.out.println("Status after confirmation: " + session.getStatus());

        // 4. Test Cancel Method (UML Method)
        System.out.println("\n[TEST 3] Testing Cancellation Logic:");
        session.cancel();
        System.out.println("Status after cancellation: " + session.getStatus());

        // 5. Robustness: Data Integrity Check
        System.out.println("\n[TEST 4] Robustness Check:");
        if (session.getBookingId() > 0 && session.getStatus() != null) {
            System.out.println("Result: SUCCESS - Module is self-contained.");
        } else {
            System.out.println("Result: FAILED - State error detected.");
        }

        System.out.println("\n================ TEST COMPLETE ================");
    }
}*/