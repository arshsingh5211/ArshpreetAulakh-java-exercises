package com.techelevator.TollCalculator;

import java.util.ArrayList;
import java.util.List;

public class TollBooth {

	public static void main(String[] args) {
		int distance = (int)Math.floor(Math.random()*(230+1)+10);
		// example in README had different distance for each vehicle but wouldn't we want to compare with same distance?
		// otherwise would put distance in for each loop to get different distance for each vehicle
		List<Vehicle> tollList = new ArrayList<Vehicle>();
		tollList.add(new Car(true));
		tollList.add(new Car(false));
		tollList.add(new Truck(4));
		tollList.add(new Truck(6));
		tollList.add(new Truck(8));
		tollList.add(new Tank());
		
		System.out.println("Vehicle\t\t\t\t\t\s\sDistance Traveled (miles)\t\t\s\s\s\sToll");
		System.out.println("------------------------------------------------------------------------------------------------"); //96 spaces
		for (Vehicle vehicle : tollList) {
			double toll = vehicle.calculateToll(distance);
			System.out.println(String.format("%-42s", vehicle.getName()) + String.format("%-42s", distance) + "$" + String.format("%.2f", toll));
		}
		

	}

}
