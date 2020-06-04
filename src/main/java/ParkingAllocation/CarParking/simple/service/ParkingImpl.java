package ParkingAllocation.CarParking.simple.service;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ParkingAllocation.CarParking.simple.model.SlotDetails;

public class ParkingImpl implements Parking {

	TreeMap<Integer, TreeSet<Integer>> parkingDataMap;

	public ParkingImpl(int numberOfFloors, int slotsInEachFloor) {

		parkingDataMap = new TreeMap<Integer, TreeSet<Integer>>();

		Set<Integer> slotSet = IntStream.rangeClosed(1, slotsInEachFloor).boxed().collect(Collectors.toSet());
		for (int i = 1; i <= numberOfFloors; i++) {
			TreeSet<Integer> sortedSlots = new TreeSet<Integer>(slotSet);
			parkingDataMap.put(i, sortedSlots);
		}
	}

	@Override
	public SlotDetails getAvilableSlot() {

		Set<Integer> keys = parkingDataMap.keySet();
		for (Integer k : keys) {
			TreeSet<Integer> availableSlots = parkingDataMap.get(k);
			if (availableSlots != null && availableSlots.size() > 0) {
				return new SlotDetails(k, availableSlots.first());
			} else
				continue;

		}

		System.out.println("Parking Aera is full no more space");
		return null;
	}

	@Override
	public void fill(SlotDetails slotDetails) {

		TreeSet<Integer> slots = parkingDataMap.get(slotDetails.getFloorNumber());
		slots.remove(slotDetails.getSlotNumber());
		parkingDataMap.put(slotDetails.getFloorNumber(), slots);
	}

	@Override
	public void retrunSlot(SlotDetails slotDetails) {
		TreeSet<Integer> slots = parkingDataMap.get(slotDetails.getFloorNumber());
		slots.add(slotDetails.getSlotNumber());
		parkingDataMap.put(slotDetails.getFloorNumber(), slots);

	}

}
