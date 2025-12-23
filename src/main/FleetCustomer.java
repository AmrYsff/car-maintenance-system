package project;

public class FleetCustomer extends Customer {
    
    public FleetCustomer(String name, String address, String nationalId, String contactNumber) {
        super(name, address, nationalId, contactNumber);
    }
    
    @Override
    public double getDiscount() {
        return 0.30;
    }
}