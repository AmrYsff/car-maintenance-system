package project;

public abstract class DailyReportGenerator {
    
    // Template method
    public final void generateReport(Appointment appointment) {
        printHeader();
        printCustomerInfo(appointment);
        printCarInfo(appointment);
        printTimeSlot(appointment);
        addRoleSpecificNotes(appointment);
        printFooter();
    }
    


	private void printHeader() {
        System.out.println("=== DAILY REPORT ===");
    }
    
    private void printCustomerInfo(Appointment appointment) {
        System.out.println("Customer: " + appointment.getCustomer().getName());
        System.out.println("Contact: " + appointment.getCustomer().getContactNumber());
    }
    
    private void printCarInfo(Appointment appointment) {
        Car car = appointment.getCar();
        System.out.println("Vehicle: " + car.getMake() + " " + car.getModel());
        System.out.println("Plate: " + car.getPlateNumber());
    }
    private void printTimeSlot(Appointment appointment) {
		System.out.println("Time slot: " + appointment.getTimeslot());
		
	}
    
    // Abstract method to be implemented by subclasses
    protected abstract void addRoleSpecificNotes(Appointment appointment);
    
    private void printFooter() {
        System.out.println("=== END REPORT ===");
    }
}
