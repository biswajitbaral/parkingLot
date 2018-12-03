package com.gojek;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parking.service.CarParkService;
import com.gojek.parking.service.LeaveParkingLotService;
import com.gojek.parking.service.ParkingLotAddService;
import com.gojek.parking.vehicle.model.ParkingParameter;

public class LeaveParkingServiceTest {

	LeaveParkingLotService leaveParkingService;

	private CarParkService parkingService;

	private ParkingLotAddService service;

	@Before
	public void setUp() throws Exception {
		leaveParkingService = new LeaveParkingLotService();
		parkingService = new CarParkService();
		service = new ParkingLotAddService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {

		ParkingParameter param = new ParkingParameter();
//		param.setValue(new String[] { "create_parking_lot", "6" });
//		service.execute(param);

		param.setValue(new String[] { "park", "KA-01-HH-2134", "White" });
		parkingService.execute(param);

		param.setValue(new String[] { "leave", "1" });
		leaveParkingService.execute(param);

	}

}
