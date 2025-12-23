package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import project.Appointment;
import project.AppointmentManager;

class bookAppointment {
	AppointmentManager appointmentManager = AppointmentManager.getInstance();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test01() {
		Appointment apointment = new Appointment(null, null, "9:00 AM - 10:00 AM") ;	
		assertTrue(appointmentManager.scheduleAppointment(apointment));
	}
	
	@Test
	void test02() {
		Appointment apointment = new Appointment(null, null, "9:00 AM - 10:00 AM") ;
		Appointment apointment2 = new Appointment(null, null, "9:00 AM - 10:00 AM") ;
		appointmentManager.scheduleAppointment(apointment);
		assertFalse(appointmentManager.scheduleAppointment(apointment2));
	}
	
	@Test
	void test03() {
		Appointment apointment = new Appointment(null, null, "6:00 PM - 7:00 PM") ;
		assertFalse(appointmentManager.scheduleAppointment(apointment));
	}
	
	
	

}
