package com.gojek.parking.service;

import java.util.ArrayList;
import java.util.List;

import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;

public class ParkingLotByColorService implements ParkingService {

	@Override
	public void execute(ParkingParameter param) {
		String color = param.getValue()[1];
		
		List<Integer> aList=ParkingDetail.getInstance().getColorLotMap().get(color);
		List<String> aa = new ArrayList<String>();
		for(Integer i:aList) {
			aa.add(""+i);
		}
		
		System.out.println(String.join(",", aa));
	}

}
