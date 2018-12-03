package com.gojek.parking.service;

import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;

public class RegistrationNoByColorService implements ParkingService {

	@Override
	public void execute(ParkingParameter param) {
		String color = param.getValue()[1];

		ParkingDetail.getInstance().getColorLotMap().get(color).forEach(slot -> {
			System.out.println(ParkingDetail.getInstance().getAvailableSlotList().get(slot).getRegistrationNo());
		});
	}

}
