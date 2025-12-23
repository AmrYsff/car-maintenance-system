package project;

public class MechanicReportGenerator extends DailyReportGenerator {
    
    @Override
    protected void addRoleSpecificNotes(Appointment appointment) {
        System.out.println("Service Report: " + appointment.getServiceReport());
        System.out.println("Mechanic Notes: Service completed successfully");
    }
}
