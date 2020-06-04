/**
 * 
 */
package ParkingAllocation.CarParking.simple.service;

import ParkingAllocation.CarParking.simple.model.SlotDetails;

public interface Parking {

	public SlotDetails getAvilableSlot();

	public void fill(SlotDetails slotDetails);

	public void retrunSlot(SlotDetails slotDetails);

}
