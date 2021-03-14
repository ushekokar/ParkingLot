package com.parking.controller;

public class MinIndexSpotAllocator extends SpotAllocator {
	public MinIndexSpotAllocator(ParkingLot p) {
		super(p);
	}
	@Override
	int getFreeSpot() {
		ParkingSpot[] p = this.parkingLot.getSpots();
		for(int i=0;i<p.length;i++) {
			if(p[i]==null) {
				return i;
			}
		}
		return -1;
	}

}
