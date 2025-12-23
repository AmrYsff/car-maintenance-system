package project;

public class Technician extends Staff {
    private AppointmentManager appointmentManager;
    private TechnicianReportGenerator reportManager;
    
    public Technician(String name, int nationalID) {
        super(name, nationalID);
        this.appointmentManager = AppointmentManager.getInstance();
        this.reportManager = new TechnicianReportGenerator();
    }
    
    public boolean addDiagnosticsResults(Appointment appointment, String results) {
        if (appointment != null) {
            appointment.setDiagnosticResults(results);
            return true;
        }
        return false;
    }
    
    public void generateDailyReport() {
    	for(Appointment apt : appointmentManager.getTodayAppointments()) 
        reportManager.generateReport(apt);
    }
}
