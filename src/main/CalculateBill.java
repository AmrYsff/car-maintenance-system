package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import project.BillingManager;
import project.CustomerManager;
import project.FleetCustomer;
import project.FrontDesk;
import project.PrivateCustomer;
import project.StaffCustomer;

class CalculateBill {
	BillingManager billCalculator = new BillingManager() ;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test1() {
		PrivateCustomer privateCustomer = new PrivateCustomer("ahmad", "Amman", "231193","94289" );
		assertEquals(50,billCalculator.calculateBill(privateCustomer) );
	}
	
	@Test
	void test2() {
		FleetCustomer fleetCustomer = new FleetCustomer("ahmad", "Amman", "231193","94289" );
		assertEquals(35,billCalculator.calculateBill(fleetCustomer) );
	}
	
	@Test
	void test3() {
		StaffCustomer staffCustomer = new StaffCustomer("ahmad", "Amman", "231193","94289" );
		assertEquals(25,billCalculator.calculateBill(staffCustomer) );
	}
}
