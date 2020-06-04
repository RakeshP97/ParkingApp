package ParkingAllocation.CarParking.simple.service;

import java.time.LocalDateTime;
import java.util.HashMap;

import ParkingAllocation.CarParking.simple.model.CarParkingData;
import ParkingAllocation.CarParking.simple.model.SlotDetails;

public class CarParkingImpl implements VechicleParking {

	public Parking parking;
	public HashMap<Integer, CarParkingData> parkedCarDetails;
	public int charges;

	public CarParkingImpl(Parking parking, int charges) {
		this.parking = parking;
		parkedCarDetails = new HashMap<Integer, CarParkingData>();
		this.charges = charges;
	}

	@Override
	public void EnterToParking(int CarId, SlotDetails slotDetails) {
		System.out.println("Allocated Slot Details Floor Number:" + slotDetails.getFloorNumber() + " Slot Number is:"
				+ slotDetails.getSlotNumber());
		parking.fill(slotDetails);
		parkedCarDetails.put(CarId, new CarParkingData(CarId, slotDetails));
	}

	@Override
	public long ExitToParking(int CarId) {

		CarParkingData data = parkedCarDetails.get(CarId);

		int dur = LocalDateTime.now().getMinute() - data.getEntryTime().getMinute();
		System.out.println(CarId + "Total time spent at parking" + dur);

		long totalHours = (long) Math.ceil(dur / 60.0);
		System.out.println(CarId + "Total hours spent at parking" + totalHours);

		parking.retrunSlot(data.getSlotDetails());

		return (totalHours * charges);
	}

}
