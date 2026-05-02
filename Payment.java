/* import java.time.LocalDate;

public class Payment {
    private int paymentId;
    private double amount;
    private String date;
    private String method;
    private String status;

    public Payment(int paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
        this.date = LocalDate.now().toString();
        this.status = "Pending";
    }

    public void process() {
        status = "Completed";
        System.out.println("Payment processed successfully.");
    }

    public void refund() {
        status = "Refunded";
        System.out.println("Payment refunded.");
    }

    // getters
    public int getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getMethod() { return method; }
    public String getStatus() { return status; }
}
*/