package project;

public class BillingManager {
	
	public double calculateBill(Customer customer)
	{
		double baseCost = 50 ;
		double discount = customer.getDiscount();
		return baseCost * (1 - discount);
	}
    
    public double calculateBill(Appointment appointment) {
        double baseCost = appointment.getAppointmentCost();
        double discount = appointment.getCustomer().getDiscount();
        return baseCost * (1 - discount);
    }
}
