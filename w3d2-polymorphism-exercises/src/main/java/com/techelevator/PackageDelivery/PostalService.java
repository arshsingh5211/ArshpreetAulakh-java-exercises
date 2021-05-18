package com.techelevator.PackageDelivery;

public class PostalService implements DeliveryDriver {
	private double perMileRate;
	private int classPerMile;
	
	public PostalService (int classPerMile) {
		this.classPerMile = classPerMile;
	}
	
	public double calculateRate(int distance, int weight) {
		return getPerMileRate(classPerMile, weight) * distance;
	}
	
	public String getName() {
		if (classPerMile == 1) return "Postal Service (First-Class)";
		else if (classPerMile == 2) return "Postal Service (Second-Class)";
		else return "Postal Service (Third-Class)";
	}
	
	public double getPerMileRate (int classPerMile, int weight) {
		if (classPerMile == 1 || classPerMile == 3) {
			if (weight > 0 && weight <= 2) {
				perMileRate = classPerMile == 1 ? 0.035 : 0.0020;
			}
			if (weight >= 3 && weight <= 8) {
				perMileRate = classPerMile == 1 ? 0.040 : 0.0022;
			}
			if (weight >= 9 && weight <= 15) {
				perMileRate = classPerMile == 1 ? 0.047 : 0.0024;
			}
			if (weight >= 16 && weight <= 48) {
				perMileRate = classPerMile == 1 ? 0.195 : 0.0150;
			}
			if (weight > 48 && weight <= 128) {
				perMileRate = classPerMile == 1 ? 0.450 : 0.0160;
			}
			if (weight > 128) {
				perMileRate = classPerMile == 1 ? 0.500 : 0.0170;
			}
		}
		else perMileRate = getPerMileRate(1, weight) / 10.00;
			return perMileRate;
	}
}
