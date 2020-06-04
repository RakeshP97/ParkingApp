package ParkingAllocation.CarParking.simple;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ParkingAllocation.CarParking.simple.model.SlotDetails;
import ParkingAllocation.CarParking.simple.service.ParkingImpl;

@RunWith(MockitoJUnitRunner.class)
public class ParkingImplTest {
	
	@Mock
	SlotDetails slotdetails;

	ParkingImpl parking = new ParkingImpl(2,2);
	
	@Test
	public void testGetAvilableSlot()
	{
		SlotDetails slotDetails = parking.getAvilableSlot();
		assertEquals(1,slotDetails.getFloorNumber());
		assertEquals(1, slotDetails.getSlotNumber());
	}
	
	@Test
	public void testFill()
	{
		
		when(slotdetails.getFloorNumber()).thenReturn(1);
		when(slotdetails.getSlotNumber()).thenReturn(1);
		parking.fill(slotdetails);
		SlotDetails slotDetails = parking.getAvilableSlot();
		assertEquals(1,slotDetails.getFloorNumber());
		assertEquals(2, slotDetails.getSlotNumber());
		
	}
	
	@Test
	public void testRetrunSlot() {
		when(slotdetails.getFloorNumber()).thenReturn(1);
		when(slotdetails.getSlotNumber()).thenReturn(1);
		parking.retrunSlot(slotdetails);
		SlotDetails slotDetails = parking.getAvilableSlot();
		assertEquals(1,slotDetails.getFloorNumber());
		assertEquals(1, slotDetails.getSlotNumber());
		
	}
	
}
