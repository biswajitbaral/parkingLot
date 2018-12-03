package com.gojek.parking.service;

import java.util.stream.IntStream;

import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;
import com.gojek.parking.vehicle.model.Vehicle;


public class ParkingStatusService implements ParkingService {

	@Override
	public void execute(ParkingParameter param) {
		if (ParkingDetail.getInstance().getSlotRegistrationNoMap().isEmpty()) {
			System.out.println("Parking lot is empty");
			return;
		}

		System.out.println("Lot No" + "    " + "Registration No" + "    " + "Color");

		IntStream.range(0, ParkingDetail.getInstance().getAvailableSlotList().size()).forEach(i -> {
			Vehicle car = ParkingDetail.getInstance().getAvailableSlotList().get(i);
			if (car != null) {
				int j = i + 1;
				System.out.println("   " + j + "    " + car.getRegistrationNo() + "    " + car.getColor());
			}
		});
	}

}
