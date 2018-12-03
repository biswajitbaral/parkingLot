package com.gojek.parking.service;

import java.util.ArrayList;
import java.util.List;

import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;

public class RegistrationNoByColorService implements ParkingService {

	@Override
	public void execute(ParkingParameter param) {
		String color = param.getValue()[1];

		
		List<Integer> slotList=ParkingDetail.getInstance().getColorLotMap().get(color);
		List<String> regList=new ArrayList<String>();
		
		for(Integer slot:slotList) {
			
			regList.add(ParkingDetail.getInstance().getAvailableSlotList().get(slot-1).getRegistrationNo());
		}
		System.out.println(String.join(",", regList));
	}

}
