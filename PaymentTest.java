/*public class PaymentTest {
    public static void main(String[] args) {
        System.out.println("========== MYFITNESS: PAYMENT MODULE TEST ==========");

        // 1. Setup: Create a new Payment object
        // Scenario: A member paying for a £35.50 Bootcamp class via Credit Card
        Payment transaction = new Payment(5001, 35.50, "Credit Card");

        // 2. Verify Initial State (Encapsulation Check)
        System.out.println("\n[TEST 1] Verifying Transaction Details:");
        System.out.println("Payment ID: " + transaction.getPaymentId());
        System.out.println("Amount: £" + transaction.getAmount());
        System.out.println("Date: " + transaction.getDate());
        System.out.println("Initial Status: " + transaction.getStatus()); // Should be Pending

        // 3. Test Process Method
        System.out.println("\n[TEST 2] Processing Payment:");
        transaction.process();
        System.out.println("Status after processing: " + transaction.getStatus());

        // 4. Test Refund Method
        System.out.println("\n[TEST 3] Testing Refund Logic:");
        transaction.refund();
        System.out.println("Final Status: " + transaction.getStatus());

        // 5. Robustness: Test Data Consistency
        System.out.println("\n[TEST 4] Robustness Check:");
        if (transaction.getAmount() > 0) {
            System.out.println("Data Integrity: Payment amount remains consistent at £" + transaction.getAmount());
        } else {
            System.out.println("ERROR: Invalid payment amount detected.");
        }

        System.out.println("\n================ TEST EXECUTION COMPLETE ================");
    }
}
    */