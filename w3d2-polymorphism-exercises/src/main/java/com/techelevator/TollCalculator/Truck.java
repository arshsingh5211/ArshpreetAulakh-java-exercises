package com.techelevator.TollCalculator;

public class Truck implements Vehicle {
	private int numAxles;

	public Truck (int numberOfAxles) {
		this.numAxles = numberOfAxles;
	}

	@Override
	public double calculateToll(double distance) {
		if (numAxles >= 8) return 0.048 * distance;
		else return numAxles == 4 ? 0.040 * distance : 0.045 * distance;
	}
	
	public int getNumAxles() {
		return numAxles;
	}

	public String getName() {
		String axles = "";
		if (numAxles >= 8) axles = "at least 8 axles";
		else axles = numAxles == 4 ? "4 axles" : "6 axles"; 
		return "Truck (" + axles + ")";
	}

}
