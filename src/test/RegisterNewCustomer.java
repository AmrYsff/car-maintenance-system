package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import project.Customer;
import project.CustomerManager;
import project.FleetCustomer;

class RegisterNewCustomer {
	CustomerManager customerManager = CustomerManager.getInstance();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	void test01() {
		Customer customer = new FleetCustomer("Yousef", "Amman", "123", "0790740283") ;
		assertTrue(customerManager.registerCustomer(customer));
	}
	
	
	@Test
	void test02() {
		Customer customer = new FleetCustomer("Yousef", "Amman" ,"123","0790740283") ;
		assertFalse(customerManager.registerCustomer(customer));
	}
	
	@Test
	void test03() {
		Customer customer = null ;
		assertFalse(customerManager.registerCustomer(customer));
	}
	

}
