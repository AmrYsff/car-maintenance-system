package project;

public abstract class Customer {
    protected String name;
    protected String address;
    protected String nationalId;
    protected String contactNumber;
    
    public Customer(String name, String address, String nationalId, String contactNumber) {
        this.name = name;
        this.address = address;
        this.nationalId = nationalId;
        this.contactNumber = contactNumber;
    }
    
    public abstract double getDiscount();
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}
