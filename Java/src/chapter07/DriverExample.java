package chapter07;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Vehicle vehicle2 = new Vehicle();
		Bus bus2 = (Bus) vehicle2;
		
		Vehicle vehicle = new Bus();
		Taxi bus = (Taxi) vehicle;
		
		driver.drive(vehicle);
	}
}