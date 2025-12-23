package project;

import java.util.*;

public class CustomerManager {
    private static CustomerManager _instance;
    private List<Customer> customers;
    
    private CustomerManager() {
        customers = new ArrayList<>();
    }
    
    public static CustomerManager getInstance() {
        if (_instance == null) {
            _instance = new CustomerManager();
        }
        return _instance;
    }
    
    public boolean registerCustomer(Customer customer) {
    	boolean customerAlreadyexist = false ;
    	
    	for(Customer cust : customers)
    	{
    		if(customer == null)
    		{
    			break ;
    		}
    		if(cust.nationalId.equals(customer.nationalId))
    		{
    			customerAlreadyexist = true ;
    		}
    		
    	}
        if (customer != null && !customers.contains(customer)&& !customerAlreadyexist) {
            customers.add(customer);
            return true;
        }
        return false;
    }
    
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
    public Customer getCustomerbyID(String id)
    {
    	for(Customer cus : customers)
    	{
    		if(cus.getNationalId().equals(id))
    		{
    			return cus ;
    		}
    	}
    	System.out.println("Customer is not found");
		return null ;
    }
}
