package com.techelevator.PackageDelivery;

public class FexEd implements DeliveryDriver {
	private double distanceFee;
	private double weightFee;
	
	public String getName() {
		return "FexEd";
	}

	public double calculateRate(int distance, int weight) {
		return distance > 0 && weight > 0 ? 20.00 + getDistanceFee(distance) + getWeightFee(weight) : 0.000;
	}

	public double getDistanceFee(int distance) {
		return distance > 500 ? 5.00 : 0.00;
	}

	public double getWeightFee(int weight) {
		return weight > 48 ? 3.00 : 0.00;
	}
}
