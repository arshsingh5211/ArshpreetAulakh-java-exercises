package com.techelevator;

import java.util.Scanner;

/*
 The Fahrenheit to Celsius conversion formula is:
 	Tc = (Tf - 32) / 1.8
 	where 'Tc' is the temperature in Celsius, and 'Tf' is the temperature in Fahrenheit
 	
 The Celsius to Fahrenheit conversion formula is:
 	Tf = Tc * 1.8 + 32
 	
 Write a command line program which prompts a user to enter a temperature, and whether its in degrees (C)elsius or (F)arenheit.
 Convert the temperature to the opposite degrees, and display the old and new temperatures to the console.
  
 $ java TempConvert
 Please enter the temperature: 58
 Is the temperature in (C)elcius, or (F)arenheit? F
 58F is 14C.
 
 Note why Tf - 32 above is enclosed in parentheses with a comment inside your code. You'll feel better for it, 
 and will start building some good programming habits while you're at it.
 */
public class TempConvert {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.print("Please enter the temperature: ");
			int temp = console.nextInt();
			System.out.print("Is the temperature in (C)elcius, or (F)arenheit? ");
			String unit = console.next();
			if (unit.equalsIgnoreCase("c") || unit.equalsIgnoreCase("celcius")) {
				System.out.print(temp + "C is " + (int)(temp * 1.8 + 32) + "F.");
				run = false;
			}
			else if (unit.equalsIgnoreCase("f") || unit.equalsIgnoreCase("farenheit")) {
				System.out.print(temp + "F is " + (int)((temp - 32) / 1.8) + "C.");
				run = false;
			}
			else System.out.println("Sorry, that is not a valid answer! Please enter (m)eters or (f)eet!\n");
		}
	}

}
