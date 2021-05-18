package com.techelevator.PackageDelivery;

public interface DeliveryDriver {
	
	public String getName();
	public double calculateRate(int distance, int weight);

}
