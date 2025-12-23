package project;

public class TechnicianReportGenerator extends DailyReportGenerator {
    
    @Override
    protected void addRoleSpecificNotes(Appointment appointment) {
    	System.out.println("Service Report: " + appointment.getServiceReport());
        System.out.println("Diagnostic Results: " + appointment.getDiagnosticResults());
        System.out.println("Technician Notes: Diagnostics completed");
    }
}
