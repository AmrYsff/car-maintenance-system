package project;
import java.util.*;

public class AppointmentManager {
    private static AppointmentManager _instance;
    private List<Appointment> todayAppointments;
    private Set<String> bookedSlots;
    private List<String>availableSlots ;
    
    private AppointmentManager() {
    	availableSlots = new ArrayList<>() ;
        todayAppointments = new ArrayList<>();
        bookedSlots = new HashSet<>();
        availableSlots.add("9:00 AM - 10:00 AM");
        availableSlots.add("10:00 AM - 11:00 AM");
        availableSlots.add("11:00 AM - 12:00 PM");
        availableSlots.add("12:00 PM - 1:00 PM") ;
        availableSlots.add("1:00 PM - 2:00 PM");
        availableSlots.add("2:00 PM - 3:00 PM");
        availableSlots.add("3:00 PM - 4:00 PM");
        availableSlots.add("4:00 PM - 5:00 PM");
        availableSlots.add("5:00 PM - 6:00 PM");
    }
    
    public static AppointmentManager getInstance() {
        if (_instance == null) {
            _instance = new AppointmentManager();
        }
        return _instance;
    }
    
    public boolean scheduleAppointment(Appointment appointment) {
        if (appointment != null && appointment.getTimeslot() != null && availableSlots.contains(appointment.getTimeslot())) {
            String requestedSlot = appointment.getTimeslot();
            
            // Check if the time slot is available
            if (!bookedSlots.contains(requestedSlot)) {
                todayAppointments.add(appointment);
                bookedSlots.add(requestedSlot);
                System.out.println("Appointment scheduled for " + requestedSlot);
                return true;
            } else {
                System.out.println("Time slot " + requestedSlot + " is already booked!");
                return false;
            }
        }
        return false;
    }
    
    public List<String> getAvailableSlots() {
        List<String> availableSlots = new ArrayList<>();
        for (String slot : this.availableSlots) {
            if (!bookedSlots.contains(slot)) {
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }
    
    
    public void printAllAppointments() {
        System.out.println("Today's Appointments:");
        if (todayAppointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
        	
            for (Appointment appointment : todayAppointments) {
                appointment.printAppointment();
                System.out.println("---");
            }
        }
    }
    
    public void printAvailableSlots() {
        System.out.println("Available Time Slots:");
        List<String> available = getAvailableSlots();
        if (available.isEmpty()) {
            System.out.println("No available slots for today.");
        } else {
            for (String slot : available) {
                System.out.println("- " + slot);
            }
        }
    }
    
    public List<Appointment> getTodayAppointments() {
        return new ArrayList<>(todayAppointments);
    }
    
    public Appointment getAppointmentByCarPlateNumber(int number) {
        for (Appointment appointment : todayAppointments) {
            if (appointment.getCar().getPlateNumber() == number) {
                return appointment;
            }
        }
        return null;
    }
    public boolean isSlotAvailable(String slot) {
        return !bookedSlots.contains(slot);
    }
}
