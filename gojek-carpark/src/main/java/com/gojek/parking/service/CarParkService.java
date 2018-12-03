package com.gojek.parking.service;

import java.text.MessageFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.gojek.parking.common.CommonConstant;
import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.util.ParkingUpdateUtil;
import com.gojek.parking.vehicle.model.Car;
import com.gojek.parking.vehicle.model.ParkingParameter;
import com.gojek.parking.vehicle.model.Vehicle;



public class CarParkService implements ParkingService {
	
	private final Lock queueLock = new ReentrantLock();

	@Override
	public void execute(ParkingParameter param) {
		Integer firstAvaiableSlot = getFirstEmptySlot();

		if (firstAvaiableSlot == null) {
			System.out.println(CommonConstant.PARKING_FULL);
			return;
		}

		Vehicle car = new Car(param.getValue()[1], param.getValue()[2]);
		ParkingUpdateUtil.addCarToParkingLot(car, firstAvaiableSlot);

		ParkingDetail.getInstance().getAvailableSlotList().set(firstAvaiableSlot, car);
		System.out.println(MessageFormat.format(CommonConstant.PARKING_USED, firstAvaiableSlot ,
				car.getRegistrationNo()));
	}

	private Integer getFirstEmptySlot() {
		queueLock.lock();
		Integer slot=null;
		try
	      {
			
		 slot=	ParkingDetail.getInstance().getslotNumbers().pollFirst();
		 return slot;
	      }finally {
	    	  queueLock.unlock();
	      }
		
	}
}
