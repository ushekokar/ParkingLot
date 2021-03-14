package com.parking.controller;


public class ParkingLot {
	ParkingSpot[] spots;
	SpotAllocator allocator;
	int capacity;
	static ParkingLot instance=null;
	public static ParkingLot getInstance(int capacity) {
		if(instance==null) {
			return new ParkingLot(capacity);
		}
		return instance;
	}
	
	private ParkingLot(int capacity) {
		spots = new ParkingSpot[capacity];
		this.allocator=null;
		this.capacity=capacity;
	}
	
	
	public SpotAllocator getAllocator() {
		return allocator;
	}


	public void setAllocator(SpotAllocator allocator) {
		this.allocator = allocator;
	}

	public ParkingSpot[]  getSpots() {
		return spots;
	}

	public void setSpots(ParkingSpot[]  spots) {
		this.spots = spots;
	}
	
	public void parkVehicle(Vehicle v) {
		if(allocator!=null) {
			int emptySpot = allocator.getFreeSpot();
			if(emptySpot!=-1) {
				ParkingSpot spot = new ParkingSpot(v);
				spots[emptySpot] = spot;
				System.out.println("Car with vehicle reg number "+v.getLicensePlate()+" has been parked at slot "+emptySpot);
			} else {
				System.out.println("Parking full");
			}
		} else {
			System.out.println("Please select allocation method");
		}
	}
	
	public void leave(int index) {
		if(index>=spots.length) {
			System.out.println("Invalid spot number entered");
			return;
		}
		
		if(spots[index]==null) {
			System.out.println("Slot already vacant");
			return;
		}
		ParkingSpot s = spots[index];
		spots[index]=null;
		System.out.print("Slot number "+ index+ " vacated,");
		System.out.print(" the car with registration number "+s.getVehicle().getLicensePlate()+ " left the space");
		System.out.println(" the driver of the car was of age "+s.getVehicle().getParkedBy().getAge());
	}
	
	public int getSlotForCarRegNumber(String regNumber) {
		for(int i=0;i<spots.length;i++) {
			if(spots[i]!=null) {
				if(spots[i].getVehicle().getLicensePlate().equals(regNumber)) {
					System.out.println("Slot for car with reg number "+regNumber+"is "+i);
					return i;
				}
			}
		}
		System.out.println("Slot for car with reg number "+regNumber+"not found.");
		return -1;
		
	}
	
	public String getSlotsForDriverAge(int age) {
		String output = "";
		for(int i=0;i<spots.length;i++) {
			if(spots[i]!=null) {
				if(spots[i].getVehicle().getParkedBy().getAge()==age) {
					output += ","+i;
				}
			}
		}
		if(output!="") {
			output = output.substring(1);
			System.out.println("Slots for driver with age "+age+" "+output);
		} else {
			System.out.println("No slots found driver with age "+age);
		}
		return output;
	}
	
	public String getRegNumberByDriverAge(int age) {
		String output = "";
		for(int i=0;i<spots.length;i++) {
			if(spots[i]!=null) {
				if(spots[i].getVehicle().getParkedBy().getAge()==age) {
					output += ","+spots[i].getVehicle().getLicensePlate();
				}
			}
		}
		if(output!="") {
			output = output.substring(1);
			System.out.println("Reg number of cars for driver with age "+age+" "+output);
		} else {
			System.out.println("No registration numbers found for driver with age "+age);
		}
		return output;
	}
}
