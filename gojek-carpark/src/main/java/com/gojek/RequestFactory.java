package com.gojek;

import com.gojek.parking.service.LeaveParkingLotService;
import com.gojek.parking.service.ParkingLotAddService;
import com.gojek.parking.service.ParkingLotByColorService;
import com.gojek.parking.service.ParkingLotByRegistrationNoService;
import com.gojek.parking.service.ParkingService;
import com.gojek.parking.service.ParkingStatusService;
import com.gojek.parking.service.RegistrationNoByColorService;

import static com.gojek.parking.common.CommonConstant.*;

public class RequestFactory {
	
	
	
	 public static ParkingService getParkingService(String requestType){
		 ParkingService pService = null;
		 switch (requestType) {
	        case CREATE_PARKING_LOT:
	        	pService = new ParkingLotAddService();
	            break;
	        case LEAVE :
	        	pService = new LeaveParkingLotService();
	            break;
	        case SLOT_FOR_CARS_COL :   
	        	pService = new ParkingLotByColorService();
	            break;
	        case STATUS:
	        	pService = new ParkingStatusService();
	            break;
	        case REG_NUM_FOR_CARS_COL :  
	            pService = new  RegistrationNoByColorService();
	            break;
	        case SLOT_NUM:
	        	 pService = new  ParkingLotByRegistrationNoService();
		            break;
	        	 
	       
	        }
	        return pService;
		 
		 
	 }

}
