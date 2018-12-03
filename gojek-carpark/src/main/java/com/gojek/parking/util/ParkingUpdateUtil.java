package com.gojek.parking.util;

import java.util.ArrayList;
import java.util.List;

import com.gojek.parking.vehicle.model.Vehicle;



public class ParkingUpdateUtil {

	public static void addCarToParkingLot(Vehicle car, Integer firstAvaiableSlot){
		ParkingDetail instance= ParkingDetail.getInstance();
		instance.getSlotRegistrationNoMap().put(car.getRegistrationNo(), firstAvaiableSlot);

		List<Integer> parkingLots = instance.getColorLotMap().get(car.getColor());
		if (parkingLots == null) {
			parkingLots = new ArrayList<>();
		}
		parkingLots.add(firstAvaiableSlot);
		instance.getColorLotMap().put(car.getColor(), parkingLots);
	}
	
	public static void leaveCarFromParkingLot(Vehicle car, Integer slot){
		ParkingDetail instance= ParkingDetail.getInstance();
		instance.getSlotRegistrationNoMap().remove(car.getRegistrationNo());
		instance.getColorLotMap().get(car.getColor()).remove(slot);
		instance.addSlotNumber(slot);
	}
}
