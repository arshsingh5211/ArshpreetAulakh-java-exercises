package com.techelevator;

import java.util.Scanner;

/*
 The foot to meter conversion formula is:
 	m = f * 0.3048
 	
 The meter to foot conversion formula is:
 	f = m * 3.2808399
 	
 Write a command line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet.
 Convert the length to the opposite measurement, and display the old and new measurements to the console.
  
 $ java LinearConvert
 Please enter the length: 58
 Is the measurement in (m)eter, or (f)eet? f
 58f is 17m.
 */

public class LinearConvert {

	public static void main(String[] args) {
	
		System.out.println("Please enter the length.");

		Scanner userInput = new Scanner(System.in);
		String line = userInput.nextLine();
		int length = Integer.parseInt(line);
		
		System.out.println("Is the measurement in (m)eter or (f)eet?");
		line = userInput.nextLine();
			if (line.equals("m") || line.equals("M")) {
				int lengthF = (int) (length * 3.2808399);
				System.out.println(length + "m is " + lengthF + "f.");
			}
			else if (line.equals("f") || line.equals("F")) {
				int lengthM = (int) (length * 0.3048);
				System.out.println(length + "f is " + lengthM + "f.");
			}
			else System.out.println(line + " is an invalid choice. Please start over and try again.");
	}
}