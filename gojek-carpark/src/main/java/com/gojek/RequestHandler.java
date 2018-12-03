package com.gojek;

import java.text.MessageFormat;

import com.gojek.parking.common.CommonConstant;
import com.gojek.parking.service.ParkingService;
import com.gojek.parking.vehicle.model.ParkingParameter;


public class RequestHandler {

	

	public static void handleRequest(String action, String[] values) {
	
		ParkingService pService=RequestFactory.getParkingService(action);
		
		if(pService == null) {
			
			System.out.println(MessageFormat.format(CommonConstant.SLOT_FREE, action));
		}
	
		ParkingParameter param = new ParkingParameter();
		param.setValue(values);
		pService.execute(param);
	}

	

}
