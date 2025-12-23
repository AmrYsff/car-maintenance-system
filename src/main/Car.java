package project;

public class Car {
    private String make;
    private String model;
    private int plateNumber;
    private Customer owner;
    
    public Car(String make, String model, int plateNumber, Customer owner) {
        this.make = make;
        this.model = model;
        this.plateNumber = plateNumber;
        this.owner = owner;
    }
    
    // Getters and setters
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getPlateNumber() { return plateNumber; }
    public void setPlateNumber(int plateNumber) { this.plateNumber = plateNumber; }
    public Customer getOwner() { return owner; }
    public void setOwner(Customer owner) { this.owner = owner; }
}
