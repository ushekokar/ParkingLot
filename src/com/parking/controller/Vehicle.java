package com.parking.controller;

public abstract class Vehicle {
	String licensePlate;
	VehicleType type;
	Driver parkedBy;
	Vehicle(VehicleType type, String licensePlate,Driver parkedBy) {
		this.licensePlate=licensePlate;
		this.type=type;
		this.parkedBy=parkedBy;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public Driver getParkedBy() {
		return parkedBy;
	}

	
}
