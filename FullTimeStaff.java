/*public class FullTimeStaff extends Staff {
    private double monthlySalary;
    private String benefits;

    //constructor
        public FullTimeStaff(int id, String name, String email, String password,
        int staffId, String role,
        double monthlySalary, String benefits)
        {

        super(id, name, email, password, staffId, role);

        this.monthlySalary = monthlySalary;
        this.benefits = benefits;
        }
    //getters
    public double getMonthlySalary() { return monthlySalary; }
    public String getBenefits()      { return benefits; }
    //setters
        public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }
    public void setBenefits(String benefits)           { this.benefits      = benefits; }

//methods
    public double calculateSalary() {
        System.out.printf("  %s monthly salary: GBP %.2f%n",
            getName(), monthlySalary);
        return monthlySalary;
    }
//    @Override
    public String toString() {
        return "[FULL-TIME]   " + super.toString()
            + String.format(" | Salary: GBP %.2f | Benefits: %s",
            monthlySalary, benefits);
    }



}
*/