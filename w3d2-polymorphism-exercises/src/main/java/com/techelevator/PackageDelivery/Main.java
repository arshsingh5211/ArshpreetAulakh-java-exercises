package com.techelevator.PackageDelivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		System.out.print("Please enter the weight of the package: ");
		int weight = console.nextInt();
		System.out.print("(P)ounds or (O)unces? ");
		String unit = console.next();
		if (unit.equalsIgnoreCase("p") || unit.equalsIgnoreCase("pounds") || unit.equalsIgnoreCase("pound")) {
			weight = getWeightInOunces(weight);
		}
		System.out.print("What distance will it be traveling to? ");
		int distance = console.nextInt();
		
		List<DeliveryDriver> deliveryCosts = new ArrayList<DeliveryDriver>();
		deliveryCosts.add(new PostalService(1));
		deliveryCosts.add(new PostalService(2));
		deliveryCosts.add(new PostalService(3));
		deliveryCosts.add(new FexEd());
		deliveryCosts.add(new SPU("four-day ground"));
		deliveryCosts.add(new SPU("two-day business"));
		deliveryCosts.add(new SPU ("next-day"));
		System.out.println((int)(15/16));
        System.out.println("\nDelivery Method\t\t\t\t$ cost");
        System.out.println("------------------------------------------------");

		for (DeliveryDriver driver : deliveryCosts) {
			double rate = driver.calculateRate(distance, weight);
			System.out.println(String.format("%-35s",driver.getName()) + "\t$" + String.format("%.2f", rate));
		}
	}
	
	static int getWeightInOunces(int weightInPounds) {
		return weightInPounds * 16;
	}
	

}
