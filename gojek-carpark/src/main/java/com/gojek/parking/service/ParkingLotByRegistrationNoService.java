package com.gojek.parking.service;

import com.gojek.parking.common.CommonConstant;
import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;

public class ParkingLotByRegistrationNoService implements ParkingService {

	@Override
	public void execute(ParkingParameter param) {

		String registrationNo = param.getValue()[1];
		Integer result = ParkingDetail.getInstance().getSlotRegistrationNoMap().get(registrationNo);

		if (result == null) {
			System.out.println(CommonConstant.NOT_FOUND);
		} else {
			System.out.println(result);
		}

	}

}
