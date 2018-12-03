package com.gojek;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.gojek.parking.service.CarParkService;
import com.gojek.parking.service.ParkingLotAddService;
import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;
import com.gojek.parking.vehicle.model.Vehicle;



public class ParkACarServiceTest {

	private ParkingLotAddService lotService;
	
	private CarParkService service;

	@Before
	public void setUp() throws Exception {
		service = new CarParkService();
		lotService = new ParkingLotAddService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		int maxSize=6;
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		lotService.execute(param);
		
		List<Vehicle> availablity = ParkingDetail.getInstance().getAvailableSlotList();
		assertTrue(availablity.size() == maxSize);
	
		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		service.execute(param);
		
	}

	@Test
	public void tesPakingFull() {
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "park", "KA-01-HH-9999", "Blue" });
		service.execute(param);
	}

}