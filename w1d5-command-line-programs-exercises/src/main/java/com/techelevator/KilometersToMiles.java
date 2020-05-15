package com.techelevator;

import java.util.Scanner;

public class KilometersToMiles {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner userInput = new Scanner (System.in);
		
		System.out.print("Enter a kilometer value to start at: ");
		String line = userInput.nextLine();
		int kmStart = Integer.parseInt(line);
		
		System.out.print("Enter a kilometer value to end with: ");
		line = userInput.nextLine();
		int kmEnd = Integer.parseInt(line);
		
		System.out.print("How many should it increment by: ");
		line = userInput.nextLine();
		int kmInt = Integer.parseInt(line);
		
		System.out.println("\nGoing from " + kmStart + " to " + kmEnd + " by increments of " + kmInt + ".");
				
		for (int i = kmStart; i <= kmEnd; i += kmInt) {
			double miles = kilometersToMiles(i);
			System.out.println(i + " kilometers is " + miles + " miles");
		}
	}

	private static double kilometersToMiles(int km) {
		double miles = (km * 0.621371);
		return miles;
	}

}
