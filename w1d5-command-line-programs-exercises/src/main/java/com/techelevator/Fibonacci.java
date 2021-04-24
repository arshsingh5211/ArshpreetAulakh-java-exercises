package com.techelevator;

import java.util.Scanner;

/*
 The Fibonacci numbers are the integers in the following sequence:  
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two.
 
Write a command line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number.

  
 $ java Fiboncci
 
Please enter the Fibonacci number: 25
 
 0, 1, 1, 2, 3, 5, 8, 13, 21
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("Please enter a value: ");
		Scanner userInput = new Scanner (System.in);
		
		int n = userInput.nextInt();
		
	    if(n >= 0) {
	        System.out.println("The Fibonacci numbers less than " + n + " are: ");
	        System.out.print("0, 1, ");
	        
	        int f2 = 1;
	        int fibonacci = 0;
	        for (int i = 0; i + f2 < n;){
	            fibonacci = i + f2;
	            i = f2;
	            f2 = fibonacci;
	            System.out.print(fibonacci + ", ");
	        }
	    } else {
	        System.out.println("There are no numbers less than " + n + " in the series");
	    }
	}
}