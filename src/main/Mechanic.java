package project;

public class Mechanic extends Staff {
    private AppointmentManager appointmentManager;
    
    public Mechanic(String name, int nationalID) {
        super(name, nationalID);
        this.appointmentManager = AppointmentManager.getInstance();
    }
    
    public void viewAppointments() {
        appointmentManager.printAllAppointments();
    }
    
    public boolean addServiceReport(Appointment appointment, String report) {
        if (appointment != null) {
            appointment.setServiceReport(report);
            return true;
        }
        return false;
    }
}
