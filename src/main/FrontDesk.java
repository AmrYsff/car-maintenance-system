package project;

import java.util.*;

public class FrontDesk extends Staff {
    private AppointmentManager appointmentManager;
    private CarManager carManager;
    private BillingManager billingManager;
    private CustomerManager customerManager;
    private RegisterCustomerFacade registerCustomerFacade;
    
    public FrontDesk(String name, int nationalID) {
        super(name, nationalID);
        this.appointmentManager = AppointmentManager.getInstance();
        this.carManager = CarManager.getInstance();
        this.billingManager = new BillingManager();
        this.customerManager = CustomerManager.getInstance();
        this.registerCustomerFacade = new RegisterCustomerFacade();
    }
    
    public boolean registerCustomer(Customer customer, Car car) {
        return registerCustomerFacade.registerCustomer(customer,car);
    }
    
    public boolean registerCar(Car car) {
        return carManager.registerCar(car);
    }
    
    public boolean scheduleAppointment(Customer customer, Car car, String preferredSlot) {
        if (appointmentManager.isSlotAvailable(preferredSlot)) {
            Appointment appointment = new Appointment(customer, car, preferredSlot);
            return appointmentManager.scheduleAppointment(appointment);
        } else {
            System.out.println("Preferred slot " + preferredSlot + " is not available.");
            System.out.println("Available alternatives:");
            appointmentManager.printAvailableSlots();
            return false;
        }
    }
    
    public boolean scheduleAppointment(Appointment appointment) {
        return appointmentManager.scheduleAppointment(appointment);
    }
    
    public double calculateServiceBill(Appointment appointment) {
        return billingManager.calculateBill(appointment);
    }
    
    public void printAppointments() {
        appointmentManager.printAllAppointments();
    }
    
    public void showAvailableSlots() {
        appointmentManager.printAvailableSlots();
    }
    
    public List<String> getAvailableSlots() {
        return appointmentManager.getAvailableSlots();
    }
}
