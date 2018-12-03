package com.gojek.parking.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gojek.parking.vehicle.model.Vehicle;



public class ParkingDetail {
	
	private static ParkingDetail pDetail=null;
	
	private ParkingDetail(){
		
	}
	
	public static ParkingDetail getInstance() {
		synchronized (ParkingDetail.class) {
			
			if(pDetail==null) {
				synchronized (ParkingDetail.class) {
					pDetail= new ParkingDetail();
					
				}
				
			}
			
			
		}
		return pDetail;
		
	}
	
	private  ArrayList<Vehicle> avlSlotList;
	
	private static ConcurrentHashMap<String, Integer> slotRegistrationNoMap;
	
	private static ConcurrentHashMap<String, List<Integer>> colorPrkLotMap;

	public ArrayList<Vehicle> createSlotList(Integer maxSize) {

		if (avlSlotList == null) {
			synchronized (ParkingDetail.class) {
				if (avlSlotList == null) {
					avlSlotList = new ArrayList<Vehicle>(Collections.nCopies(maxSize, null));
					slotRegistrationNoMap= new ConcurrentHashMap<String,Integer>();
					colorPrkLotMap= new ConcurrentHashMap<>();
				}
			}
		}
		return avlSlotList;
	}

	public ArrayList<Vehicle> getAvailableSlotList() {

		return avlSlotList;
	}
	
	public ArrayList<Vehicle> increaseAvailableSlotList(int capacity) {

		if (avlSlotList != null) {
			
			synchronized (ParkingDetail.class) {

				avlSlotList.ensureCapacity(capacity);
			}

		}

		return avlSlotList;
	}
	
	public Map<String, Integer> getSlotRegistrationNoMap() {
		
		return slotRegistrationNoMap;
	}

	public Map<String, List<Integer>> getColorLotMap() {
		
		return colorPrkLotMap;
	}

}
