package project;

public class StaffCustomer extends Customer {
    
    public StaffCustomer(String name, String address, String nationalId, String contactNumber) {
        super(name, address, nationalId, contactNumber);
    }
    
    @Override
    public double getDiscount() {
        return 0.50;
    }
}
