package ParkingAllocation.CarParking.simple.model;

public class SlotDetails {
	
	private int floorNumber;
	private int SlotNumber;
	
	
	
	public SlotDetails(int floorNumber, int slotNumber) {
		super();
		this.floorNumber = floorNumber;
		SlotNumber = slotNumber;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public int getSlotNumber() {
		return SlotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		SlotNumber = slotNumber;
	}
	

}
