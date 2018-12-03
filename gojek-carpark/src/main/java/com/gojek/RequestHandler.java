package com.gojek;

import com.gojek.parking.service.ParkingService;
import com.gojek.parking.vehicle.model.ParkingParameter;


public class RequestHandler {

	

	public static void handleRequest(String action, String[] values) {
	
		ParkingService pService=RequestFactory.getParkingService(action);
	
		ParkingParameter param = new ParkingParameter();
		param.setValue(values);
		pService.doAction(param);
	}

	

}
