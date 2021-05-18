package com.techelevator.PackageDelivery;

public class SPU implements DeliveryDriver {
	private String shipType;
	
	public SPU (String shipLength) {
		this.shipType = shipLength;
	}
	
	public String getName() {
		return "SPU" +  " (" + shipType + ")";
	}
	
	public double calculateRate(int distance, int weight) {
		double weightAsDouble = Math.ceil(weight / 16.00);
		int weightInLbs = (int)(weightAsDouble);
		double rate = 0.00;
		if (shipType.equals("four-day ground")) {
			rate = (weightInLbs * 0.0050) * distance;
		}
		if (shipType.equals("two-day business")) {
			rate = (weightInLbs * 0.050) * distance;
		}
		if (shipType.equals("next-day")) {
			rate = (weightInLbs * 0.075) * distance;
		}
			return rate;
	}

	public String getShipType() {
		return shipType;
	}
}
