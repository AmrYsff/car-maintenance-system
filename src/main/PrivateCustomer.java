package project;

public class PrivateCustomer extends Customer {
    
    public PrivateCustomer(String name, String address, String nationalId, String contactNumber) {
        super(name, address, nationalId, contactNumber);
    }
    
    @Override
    public double getDiscount() {
        return 0 ;
    }
}
