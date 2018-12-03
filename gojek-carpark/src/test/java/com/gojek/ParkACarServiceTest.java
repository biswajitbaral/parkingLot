package com.gojek;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.gojek.parking.service.CarParkService;
import com.gojek.parking.service.LeaveParkingLotService;
import com.gojek.parking.service.ParkingLotAddService;
import com.gojek.parking.service.ParkingLotByColorService;
import com.gojek.parking.service.ParkingLotByRegistrationNoService;
import com.gojek.parking.service.ParkingStatusService;
import com.gojek.parking.service.RegistrationNoByColorService;
import com.gojek.parking.util.ParkingDetail;
import com.gojek.parking.vehicle.model.ParkingParameter;
import com.gojek.parking.vehicle.model.Vehicle;



public class ParkACarServiceTest {

	private ParkingLotAddService lotService;
	
	private CarParkService service;
	
	private LeaveParkingLotService leaveParkingService;
	
	private	ParkingLotByColorService prkLotByColorService;
	
	private ParkingStatusService stService;
	private RegistrationNoByColorService regByColrService;
	 private ParkingLotByRegistrationNoService slotNumWithRegService;

	@Before
	public void setUp() throws Exception {
		service = new CarParkService();
		lotService = new ParkingLotAddService();
		leaveParkingService = new LeaveParkingLotService();
		prkLotByColorService= new ParkingLotByColorService();
		stService= new ParkingStatusService();
		regByColrService= new RegistrationNoByColorService();
		slotNumWithRegService=new ParkingLotByRegistrationNoService();
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
	
	@Test
	public void testLeave() {

		ParkingParameter param = new ParkingParameter();

		param.setValue(new String[] { "park", "KA-01-HH-2134", "White" });
		service.execute(param);

		param.setValue(new String[] { "leave", "1" });
		leaveParkingService.execute(param);

	}
	
	@Test
	public void testCarSlotWithColor() {
		
		ParkingParameter param = new ParkingParameter();
		

		param.setValue(new String[] { "park", "KA-01-HH-5555", "White" });
		service.execute(param);

		param.setValue(new String[] { "slot_numbers_for_cars_with_colour", "White" });
		prkLotByColorService.execute(param);
		
	}
	@Test
	public void testStatus() {
		
		ParkingParameter param = new ParkingParameter();
		
		param.setValue(new String[] { "status" });
		stService.execute(param);
		
	}
	
	@Test
	public void testRegistrationNumWithColor() {
		
		ParkingParameter param = new ParkingParameter();
		
		param.setValue(new String[] { "registration_numbers_for_cars_with_colour", "White" });
		regByColrService.execute(param);
		
	}
	@Test
	public void testSlotNumWithRegistration() {
		
		ParkingParameter param = new ParkingParameter();
		
		param.setValue(new String[] { "slot_number_for_registration_number", "MH-04-AY-1111" });
		slotNumWithRegService.execute(param);
		
	}

}
