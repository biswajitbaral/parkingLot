package com.gojek.parking.service;

import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;

public class ParkingLotByColorService implements ParkingService {

	@Override
	public void execute(ParkingParameter param) {
		String color = param.getValue()[1];
		ParkingDetail.getInstance().getColorLotMap().get(color).forEach(value -> {
			System.out.println(value + 1);
		});
	}

}
