package com.gojek;

import com.gojek.parking.service.ParkingLotAddService;
import com.gojek.parking.service.ParkingService;
import static com.gojek.parking.common.CommonConstant.*;

public class RequestFactory {
	
	
	
	 public static ParkingService getParkingService(String requestType){
		 ParkingService pService = null;
		 switch (requestType) {
	        case CREATE_PARKING_LOT:
	        	pService = new ParkingLotAddService();
	            break;
	 
	       
	        }
	        return pService;
		 
		 
	 }

}
