package ParkingAllocation.CarParking.simple;

import java.util.Scanner;

import ParkingAllocation.CarParking.simple.model.SlotDetails;
import ParkingAllocation.CarParking.simple.service.CarParkingImpl;
import ParkingAllocation.CarParking.simple.service.Parking;
import ParkingAllocation.CarParking.simple.service.ParkingImpl;
import ParkingAllocation.CarParking.simple.service.VechicleParking;

public class CarParkingMainApp {

	public static void main(String[] args) {

		System.out.println("Welocme to Parking place Setup!");
		parkingOperation();

	}

	public static void parkingOperation() {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter the Number floor in parking lot");
			int floorCount = s.nextInt();
			System.out.println("Enter the Number slots in each floor");
			int slotCount = s.nextInt();
			System.out.println("Enter the Fee for each slot for one hour is:");
			int charge = s.nextInt();
			Parking p = new ParkingImpl(floorCount, slotCount);
			VechicleParking v = new CarParkingImpl(p, charge);

			while (true) {
				System.out.println("Enter choice  1. Entery Gate 2. Exit Gate  3. Application Exit");
				int choice = s.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter Car id:");
					int carId = s.nextInt();
					SlotDetails slotDetails = p.getAvilableSlot();
					if (slotDetails == null)
						return;
					v.EnterToParking(carId, slotDetails);
					break;
				case 2:
					System.out.println("Enter Car id:");
					carId = s.nextInt();
					long price = v.ExitToParking(carId);
					System.out.println("Total amount need to pay :" + price);
					break;
				case 3:
					System.out.println("Done with parking application");
					return;
				default:
					break;

				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
