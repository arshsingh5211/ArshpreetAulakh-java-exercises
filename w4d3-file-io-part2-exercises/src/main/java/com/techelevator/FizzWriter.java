package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FizzWriter {

	public static void main(String[] args) {
		try {
			File output = new File("/Users/arsh/Desktop/TechElevator/arshpreetaulakh-java-exercises/w4d3-file-io-part2-exercises/FizzBuzz.txt");
			if (output.createNewFile()) {
				System.out.println("File " + output.getName() + " created successfully!");
			}
			else System.err.println("Error: " + output.getName() + " already exists! Please select a different name for the new file or rename the existing file.");
			FileWriter fizzBuzzResults = new FileWriter ("/Users/arsh/Desktop/TechElevator/arshpreetaulakh-java-exercises/w4d3-file-io-part2-exercises/FizzBuzz.txt");
			fizzBuzzResults.write(printFizzBuzzToFile());
			fizzBuzzResults.close();
		}
		catch (IOException e) {
			System.err.println("Sorry, there is an IO Exception:");
			e.printStackTrace();
		}
	}
	
	public static String FizzBuzz (int num) {
		if (num % 3 == 0 && num % 5 == 0) return "FizzBuzz";
		else if (num % 5 == 0) return "Fizz";
		else if (num % 3 == 0) return "Buzz";
		else return Integer.toString(num);
	}
	
	public static String printFizzBuzzToFile() {
		String printedString = "";
		printedString = "Results of Fizz Buzz for all numbers 1-300\n\n";
		for (int i = 1; i < 301; i++) {
			printedString += "Number: " + i + ": " + FizzBuzz(i) + "\n";
		}
			return printedString;
	}
	
	

}
