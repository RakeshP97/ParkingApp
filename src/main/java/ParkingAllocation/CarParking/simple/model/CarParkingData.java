package ParkingAllocation.CarParking.simple.model;

import java.time.LocalDateTime;

public class CarParkingData {
	
	private int carId;
	private LocalDateTime entryTime;
	private SlotDetails slotDetails;
	
	public CarParkingData(int carId, SlotDetails slotDetails) {
		super();
		this.carId = carId;
		this.entryTime = LocalDateTime.now();
		this.slotDetails = slotDetails;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public SlotDetails getSlotDetails() {
		return slotDetails;
	}

	public void setSlotDetails(SlotDetails slotDetails) {
		this.slotDetails = slotDetails;
	}
	
	
	
	

}
