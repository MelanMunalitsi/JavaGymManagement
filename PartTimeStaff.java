/*public class PartTimeStaff extends Staff {
        private double hourlyRate;
    private int    hoursWorked;
    // Constructor
    public PartTimeStaff(int id, String name, String email, String password,
        int staffId, String role,
        double hourlyRate, int hoursWorked) {

        super(id, name, email, password, staffId, role);

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

     // Getters
    public double getHourlyRate()  { return hourlyRate; }
    public int    getHoursWorked() { return hoursWorked; }
    // Setters
        public void setHourlyRate(double hourlyRate)   { this.hourlyRate  = hourlyRate; }
    public void setHoursWorked(int hoursWorked)    { this.hoursWorked = hoursWorked; }
    public double calculatePay() {
        double pay = hourlyRate * hoursWorked;
        System.out.printf("  %s pay: GBP %.2f/hr x %d hrs = GBP %.2f%n",
        getName(), hourlyRate, hoursWorked, pay);
        return pay;
    }
    public void updateHours(int additionalHours) {
        hoursWorked += additionalHours;
        System.out.printf("  %s hours updated +%d -> Total: %d hrs%n",
        getName(), additionalHours, hoursWorked);
    }
    @Override
    public String toString() {
        return "[PART-TIME]   " + super.toString()
            + String.format(" | Rate: GBP %.2f/hr | Hours: %d | Pay: GBP %.2f",
            hourlyRate, hoursWorked,
            hourlyRate * hoursWorked);
    }



}
*/