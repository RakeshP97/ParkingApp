package ParkingAllocation.CarParking.simple;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ParkingAllocation.CarParking.simple.model.CarParkingData;
import ParkingAllocation.CarParking.simple.model.SlotDetails;
import ParkingAllocation.CarParking.simple.service.CarParkingImpl;
import ParkingAllocation.CarParking.simple.service.Parking;

@RunWith(MockitoJUnitRunner.class)
public class CarParkingImplTest {
	
	@Mock
	Parking parking;
	@Mock
	SlotDetails slotdetails;
	
	@Mock
	CarParkingData carParkingData;
	
	@Test
	public void testEnterToParking()
	{
		CarParkingImpl carParkingImpl = new CarParkingImpl(parking,10);
		when(slotdetails.getFloorNumber()).thenReturn(2);
		when(slotdetails.getSlotNumber()).thenReturn(3);
		doNothing().when(parking).fill(any(SlotDetails.class));
		carParkingImpl.EnterToParking(101, slotdetails);
		
	}
	
	@Test
	public void testExitToParking()
	{
		CarParkingImpl carParkingImpl = new CarParkingImpl(parking,10);
		carParkingImpl.parkedCarDetails.put(101,  carParkingData);
		when(carParkingData.getEntryTime()).thenReturn(LocalDateTime.now());
		doNothing().when(parking).retrunSlot(any(SlotDetails.class));
		long price = carParkingImpl.ExitToParking(101);
		assertEquals(0, price);
		
	}

}
