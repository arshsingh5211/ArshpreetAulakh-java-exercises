package com.techelevator.TollCalculator;

public class Car implements Vehicle {
	private boolean hasTrailer;
	
	public Car (boolean isTowing) {
		this.hasTrailer = isTowing;
	}
	
	public String getName() { // make sure this is needed
		return hasTrailer ? "Car (with trailer)" : "Car (no trailer)";
	}

	@Override
	public double calculateToll(double distance) {
		double toll = distance * 0.020;
		return hasTrailer ? toll += 1.00 : toll;
	}
	
	public boolean getHasTrailer() {
		return hasTrailer;
	}

}
