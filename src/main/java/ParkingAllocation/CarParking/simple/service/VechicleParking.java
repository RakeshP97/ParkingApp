package ParkingAllocation.CarParking.simple.service;

import ParkingAllocation.CarParking.simple.model.SlotDetails;

public interface VechicleParking {

	public void EnterToParking(int CarId, SlotDetails slotDetails);
	
	public long ExitToParking(int CarId);
	
	
	
}
