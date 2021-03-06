package com.gojek.parking.service;

import java.text.MessageFormat;

import com.gojek.parking.common.CommonConstant;
import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;



public class ParkingLotAddService implements ParkingService {

	@Override
	public void execute(ParkingParameter param) throws NumberFormatException {
		try {

			Integer capacity = Integer.valueOf((String) param.getValue()[1]);
			ParkingDetail.getInstance().createSlotList(capacity);
			System.out.println(MessageFormat.format(CommonConstant.PARKING_LOT_CREATED, capacity));

		} catch (NumberFormatException e) {
			System.out.println(CommonConstant.ERROR_PARKING_LOT);
		}

	}

}
