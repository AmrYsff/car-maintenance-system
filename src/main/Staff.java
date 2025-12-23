package project;

public abstract class Staff {
    protected String name;
    protected int nationalID;
    
    public Staff(String name, int nationalID) {
        this.name = name;
        this.nationalID = nationalID;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getNationalID() { return nationalID; }
    public void setNationalID(int nationalID) { this.nationalID = nationalID; }
}
