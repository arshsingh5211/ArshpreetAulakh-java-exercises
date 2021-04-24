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
		Scanner console = new Scanner (System.in);
		boolean run = true;
		while (run) {
			System.out.print("Please enter the length: ");
			int len = console.nextInt();
			System.out.print("Is the measurement in (m)eter, or (f)eet? ");
			String unit = console.next();
			if (unit.equalsIgnoreCase("m") || unit.equalsIgnoreCase("meter") || unit.equalsIgnoreCase("meters")) {
				System.out.println(len + "m is " + (int)(len * 3.2808399) + "f.");
				run = false;
			}
			else if (unit.equalsIgnoreCase("f") || unit.equalsIgnoreCase("foot") || unit.equalsIgnoreCase("feet")) {
				System.out.println(len + "f is " + (int)(len * 0.3048) + "m.");
				run = false;
			}
			else System.out.println("Sorry, that is not a valid answer! Please enter (m)eters or (f)eet!\n");
		}
	}

}
