package project;

public class Appointment {
    private Customer customer;
    private Car car;
    private String timeslot;
    private String serviceReport;
    private String diagnosticResults;
    private final int APPOINTMENT_COST = 50;
    
    public Appointment(Customer customer, Car car,String timeslot) {
        this.customer = customer;
        this.car = car;
        this.timeslot = timeslot;
    }
    
    public void printAppointment() {
        System.out.println("Appointment Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car: " + car.getModel() + " " + car.getMake());
        System.out.println("Plate: " + car.getPlateNumber());
        System.out.println("Time Slot: " + timeslot);
        System.out.println("Cost Before Discount: $" + APPOINTMENT_COST);
    }
    
    // Getters and setters
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }
    public String getTimeslot() { return timeslot; }
    public void setTimeslot(String timeslot) { this.timeslot = timeslot; }
    public String getServiceReport() { return serviceReport; }
    public void setServiceReport(String serviceReport) { this.serviceReport = serviceReport; }
    public String getDiagnosticResults() { return diagnosticResults; }
    public void setDiagnosticResults(String diagnosticResults) { this.diagnosticResults = diagnosticResults; }
    public int getAppointmentCost() { return APPOINTMENT_COST; }
}
