package com.parking.controller;

public class Car extends Vehicle {
	public Car(String licensePlate,Driver parkedBy){
		super(VehicleType.CAR,licensePlate,parkedBy);
	}
}
