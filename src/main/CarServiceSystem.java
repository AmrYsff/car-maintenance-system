package project;

import java.util.*;

public class CarServiceSystem {

	private static Scanner scanner = new Scanner(System.in);

	private static CustomerManager customerManager = CustomerManager.getInstance();

	private static CarManager carManager = CarManager.getInstance();

	private static AppointmentManager appointmentManager = AppointmentManager.getInstance();

	private static FrontDesk frontDesk = new FrontDesk("Yousef", 123);

	private static Mechanic mechanic = new Mechanic("Ahmad", 111);

	private static Technician technician = new Technician("Ali", 125);

	public static void main(String[] args) {

		runInteractiveSystem();
	}

	private static void displayMainMenu() {

		System.out.println("\n" + "=".repeat(50));

		System.out.println(" MAIN MENU");

		System.out.println("=".repeat(50));

		System.out.println("1. FrontDesk Employee");

		System.out.println("2. Mechanic Employee");

		System.out.println("3. Technician Employee");

		System.out.println("0. Exit System");

		System.out.println("=".repeat(50));

	}

	private static void runInteractiveSystem() {

		while (true) {

			displayMainMenu();

			int choice = getIntInput("Enter your choice: ");

			switch (choice) {

			case 1:

				runFrontDeskInterface();

				break;

			case 2:

				mechanicOperations();

				break;

			case 3:

				technicianOperations();

				break;

			case 0:

				System.out.println("Thank you for using Car Service Management System!");

				return;

			default:

				System.out.println("Invalid choice. Please try again.");

			}

			System.out.println("\nPress Enter to continue...");

			scanner.nextLine();

		}

	}

	private static void technicianOperations() {

		System.out.println("\n=== Technician Operations ===");

		System.out.println("1. Add Diagnostic Results");

		System.out.println("2. Generate Daily Report");

		int choice = getIntInput("Select operation (1-2): ");

		switch (choice) {

		case 1:

			addDiagnosticResults();

			break;

		case 2:

			technician.generateDailyReport();

			break;

		default:

			System.out.println("Invalid choice!");

		}

	}

	private static void addDiagnosticResults() {

		List<Appointment> appointments = appointmentManager.getTodayAppointments();

		if (appointments.isEmpty()) {

			System.out.println("No appointments to add diagnostic results to.");

			return;

		}

		System.out.println("Select appointment to add diagnostic results:");

		for (int i = 0; i < appointments.size(); i++) {

			Appointment apt = appointments.get(i);

			System.out.println((i + 1) + ". " + apt.getTimeslot() +

					" - " + apt.getCustomer().getName());

		}

		int index = getIntInput("Select appointment (1-" + appointments.size() + "): ") - 1;

		if (index < 0 || index >= appointments.size()) {

			System.out.println("Invalid selection!");

			return;

		}

		System.out.print("Enter diagnostic results: ");

		String results = scanner.nextLine();

		if (technician.addDiagnosticsResults(appointments.get(index), results)) {

			System.out.println("Diagnostic results added successfully!");

		} else {

			System.out.println("Failed to add diagnostic results.");

		}

	}

	private static void mechanicOperations() {

		System.out.println("\n=== Mechanic Operations ===");

		System.out.println("1. View Appointments");

		System.out.println("2. Add Service Report");

		int choice = getIntInput("Select operation (1-2): ");

		switch (choice) {

		case 1:

			mechanic.viewAppointments();

			break;

		case 2:

			addServiceReport();

			break;

		default:

			System.out.println("Invalid choice!");

		}

	}

	private static void addServiceReport() {

		List<Appointment> appointments = appointmentManager.getTodayAppointments();

		if (appointments.isEmpty()) {

			System.out.println("No appointments to add service reports to.");

			return;

		}

		System.out.println("Select appointment to add service report:");

		for (int i = 0; i < appointments.size(); i++) {

			Appointment apt = appointments.get(i);

			System.out.println((i + 1) + ". " + apt.getTimeslot() +

					" - " + apt.getCustomer().getName());

		}

		int index = getIntInput("Select appointment (1-" + appointments.size() + "): ") - 1;

		if (index < 0 || index >= appointments.size()) {

			System.out.println("Invalid selection!");

			return;

		}

		System.out.print("Enter service report: ");

		String report = scanner.nextLine();

		if (mechanic.addServiceReport(appointments.get(index), report)) {

			System.out.println("Service report added successfully!");

		} else {

			System.out.println("Failed to add service report.");

		}

	}

	private static void runFrontDeskInterface() {

		while (true) {
			displayFrontDeskMenu();
			int choice = getIntInput("Enter your choice: ");
			switch (choice) {
			case 1:
				registerNewCustomer();
				break;
			case 2:
				registerNewCar();
				break;
			case 3:
				scheduleAppointment();
				break;
			case 4:
				billingOperations();
				break;
			case 5:
				viewAppointments();
				break;
			case 0:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
			System.out.println("\nPress Enter to continue...");
			scanner.nextLine();
		}

	}

	private static void viewAppointments() {

		frontDesk.printAppointments();

	}

	private static void billingOperations() {

		int carPlate = getIntInput("Enter car plate number ");

		Appointment appointment = appointmentManager.getAppointmentByCarPlateNumber(carPlate);

		if (appointment != null) {
			System.out.println(frontDesk.calculateServiceBill(appointment));
		} else {
			System.out.println("No appointment found for this car.");
		}
	}

	private static void scheduleAppointment() {

		System.out.println("\n=== Schedule Appointment ===");

		System.out.println("Enter Customer ID");

		String id = scanner.nextLine();

		Customer customer = customerManager.getCustomerbyID(id);

		int platenumber = getIntInput("Enter Car plate number ");

		Car car = carManager.getCarByPlateNumber(platenumber);

		int index = 1;

		List<String> avaialbeSlots = frontDesk.getAvailableSlots();

		for (String s : avaialbeSlots)

		{
			System.out.print(index + " ");
			index++;
			System.out.println(s);

		}

		int choise = getIntInput("Enter the number of the time that suits you");

		if (choise <= avaialbeSlots.size() && choise > 0)

		{

			Appointment apointment = new Appointment(customer, car, avaialbeSlots.get(choise - 1));

			frontDesk.scheduleAppointment(apointment);

		}

		else

		{

			System.out.println("the numbe you entered is not valid ");

		}

	}

	private static void registerNewCar() {

		System.out.println("\n=== Register New Car ===");

		System.out.println("Enter Car Make");

		String make = scanner.nextLine();

		System.out.println("Enter Car Model");

		String model = scanner.nextLine();

		int plateNumber = getIntInput("Enter Plate Number");

		System.out.println("Enter Customer ID");

		String customerID = scanner.nextLine();

		Customer carOwner = null;
		for (Customer customer : customerManager.getCustomers()) {
			if (customer.nationalId.equals(customerID)) {
				carOwner = customer;
				break;
			}
		}

		if (carOwner != null) {
			Car car = new Car(make, model, plateNumber, carOwner);
			frontDesk.registerCar(car);
			System.out.println("Car registered successfully.");
		} else {
			System.out.println("Customer with this ID is not found.");
		}

	}

	private static void displayFrontDeskMenu() {

		System.out.println("1. Register New Customer");

		System.out.println("2. Register New Car");

		System.out.println("3. Schedule Appointment");

		System.out.println("4. PrintServiceBillForCustomer");

		System.out.println("5. View Today's Appointments");

		System.out.println("0. Exit");

	}

	private static int getIntInput(String prompt) {

		while (true) {

			try {

				System.out.print(prompt);

				int value = Integer.parseInt(scanner.nextLine());

				return value;

			} catch (NumberFormatException e) {

				System.out.println("Please enter a valid number.");

			}

		}

	}

	private static void registerNewCustomer() {

		System.out.println("\n=== Register New Customer ===");

		System.out.println("Customer Types:");

		System.out.println("1. Private Customer");

		System.out.println("2. Fleet Customer");

		System.out.println("3. Staff Customer");

		int type = getIntInput("Select customer type (1-3): ");

		System.out.print("Enter customer name: ");

		String name = scanner.nextLine();

		System.out.print("Enter address: ");

		String address = scanner.nextLine();

		System.out.print("Enter national ID: ");

		String nationalId = scanner.nextLine();

		System.out.print("Enter contact number: ");

		String contact = scanner.nextLine();

		System.out.println("Enter Car Make");

		String make = scanner.nextLine();

		System.out.println("Enter Car Model");

		String model = scanner.nextLine();

		int plateNumber = getIntInput("Enter Plate Number");

		Customer customer = null;

		switch (type) {

		case 1:

			customer = new PrivateCustomer(name, address, nationalId, contact);

			break;

		case 2:

			customer = new FleetCustomer(name, address, nationalId, contact);

			break;

		case 3:

			customer = new StaffCustomer(name, address, nationalId, contact);

			break;

		default:

			System.out.println("Invalid customer type!");

			return;

		}

		Car customerCar = new Car(make, model, plateNumber, customer);

		if (frontDesk.registerCustomer(customer, customerCar)) {

			System.out.println("Customer registered successfully!");

		} else {

			System.out.println("Failed to register customer.");

		}

	}

}