import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.parking.controller.*;
public class Main {


	public static void main(String[] args) {
	BufferedReader br=null;
	try {
		 br = new BufferedReader(new FileReader(args[0]));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	ParkingLot parkingLot = null;
	String line=null;
    try {
		while ((line = br.readLine()) != null) {
		   String[] parts = line.split(" ");
		   
		   if(line.matches("^Create_parking_lot.*")) {
			   parkingLot = ParkingLot.getInstance(Integer.parseInt(parts[1]));
			   SpotAllocator allocator = new MinIndexSpotAllocator(parkingLot);
			   parkingLot.setAllocator(allocator);
			   continue;
		   }
		   
		   if(parkingLot==null) {
			   System.out.println("Create parking lot first");
			   return;
		   }
		   
		   if(line.matches("^Park.*")) {
			 Driver d = new Driver("Somename",Integer.parseInt(parts[3]));
			 Vehicle v = new Car(parts[1],d);
			 parkingLot.parkVehicle(v);
			 continue;
		   }
		   
		   if(line.matches("^Slot_numbers_for_driver_of_age.*")) {
			   parkingLot.getSlotsForDriverAge(Integer.parseInt(parts[1]));
			   continue;
		   }
		   
		   if(line.matches("^Slot_number_for_car_with_number.*")) {
			   parkingLot.getSlotForCarRegNumber(parts[1]);
			   continue;
		   }
		   
		   if(line.matches("^Vehicle_registration_number_for_driver_of_age.*")) {
			   parkingLot.getRegNumberByDriverAge(Integer.parseInt(parts[1]));
			   continue;
		   }
		   
		   if(line.matches("^Leave.*")) {
			   parkingLot.leave(Integer.parseInt(parts[1]));
			   continue;
		   }
		   
		   System.out.println("Incorrect command specified, command: "+line);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
    
	}

}
