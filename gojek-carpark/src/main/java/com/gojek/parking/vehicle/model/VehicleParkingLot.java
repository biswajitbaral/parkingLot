package com.gojek.parking.vehicle.model;

public class VehicleParkingLot implements ParkingLot {

	private long spaceId;

	public VehicleParkingLot() {

	}

	@Override
	public Long getSpaceId() {
		return spaceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 13;
		result = (int) (prime * result + spaceId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleParkingLot other = (VehicleParkingLot) obj;
		if (spaceId != other.spaceId)
			return false;
		return true;
	}

}
