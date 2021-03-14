package com.parking.controller;

public class ParkingSpot {
	private boolean isFree;
	private Vehicle vehicle;
	
	ParkingSpot() {
		isFree  = true;
		vehicle= null;
	}
	
	ParkingSpot(Vehicle v) {
		this.vehicle=v;
		this.isFree=false;
	}
	
	
	public boolean isFree() {
		return isFree;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void removeVehicle() {
		this.isFree = true;
		this.vehicle=null;
	}
}
