package com.gojek.parking.service;

import java.text.MessageFormat;

import com.gojek.parking.common.CommonConstant;
import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.util.ParkingUpdateUtil;
import com.gojek.parking.vehicle.model.ParkingParameter;
import com.gojek.parking.vehicle.model.Vehicle;



public class LeaveParkingLotService implements ParkingService {

	@Override
	public void execute(ParkingParameter param) {

		try {
			Integer slot = Integer.parseInt(param.getValue()[1]);
			Vehicle car = ParkingDetail.getInstance().getAvailableSlotList().get(slot - 1);

			if (car == null) {
				System.out.println(CommonConstant.NOT_FOUND);
				return;
			}

			ParkingDetail.getInstance().getAvailableSlotList().set(slot - 1, null);
			
			ParkingUpdateUtil.leaveCarFromParkingLot(car, slot);

			System.out.println(MessageFormat.format(CommonConstant.SLOT_FREE, slot));

		} catch (NumberFormatException ex) {
			System.out.println(CommonConstant.ERROR_INVALID_SPACE_NO);
			return;
		}

	}

}
