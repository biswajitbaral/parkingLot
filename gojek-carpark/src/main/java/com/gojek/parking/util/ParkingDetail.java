package com.gojek.parking.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
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
	
	private TreeSet<Integer> slotNumbers;
	
	
	private static ConcurrentHashMap<String, Integer> slotRegistrationNoMap;
	
	private static ConcurrentHashMap<String, List<Integer>> colorPrkLotMap;

	public ArrayList<Vehicle> createSlotList(Integer maxSize) {

		if (avlSlotList == null) {
			synchronized (ParkingDetail.class) {
				if (avlSlotList == null) {
					avlSlotList = new ArrayList<Vehicle>(Collections.nCopies(maxSize, null));
					slotRegistrationNoMap= new ConcurrentHashMap<String,Integer>();
					colorPrkLotMap= new ConcurrentHashMap<>();
					slotNumbers= new TreeSet<Integer>();
					for(int i=1;i<=maxSize;i++) {
						slotNumbers.add(i);
					}
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
	
	public TreeSet<Integer> getslotNumbers() {
			synchronized (this) {
				return slotNumbers;
			}
			
		}
	public void addSlotNumber(int slot) {
		synchronized (this) {
		 slotNumbers.add(slot);
		}
	}

}
