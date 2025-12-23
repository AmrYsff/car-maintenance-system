package project;

public class RegisterCustomerFacade {
    private CustomerManager customerManager;
    private CarManager carManager;
    
    public RegisterCustomerFacade() {
        this.customerManager = CustomerManager.getInstance();
        this.carManager = CarManager.getInstance();
    }
    
    public boolean registerCustomer(Customer customer, Car car) {
        // Simplified registration process
        customerManager.registerCustomer(customer);
        return carManager.registerCar(car) ;
    }
}
