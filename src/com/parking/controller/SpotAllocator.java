package com.parking.controller;

public abstract class SpotAllocator {
   ParkingLot parkingLot;
   public SpotAllocator(ParkingLot p) {
	   this.parkingLot=p;
   }
   abstract int getFreeSpot();
}
