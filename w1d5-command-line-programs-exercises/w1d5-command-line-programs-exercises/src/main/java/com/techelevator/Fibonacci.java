package com.techelevator;

import java.util.ArrayList;
import java.util.List;
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
		
		Scanner console = new Scanner (System.in);
		System.out.print("Please enter the Fibonacci number: ");
		int end = console.nextInt();
		System.out.println(getList(end).toString().replace("[", "").replace("]", ""));
	}
	
	static List<Integer> getList(int endInt) {
		List<Integer> fibList = new ArrayList<>();
		fibList.add(0);
		fibList.add(1);
		int next = fibList.get(fibList.size()-1) + fibList.get(fibList.size()-2);
		while (next < endInt) {
			fibList.add(next);
			next = fibList.get(fibList.size()-1) + fibList.get(fibList.size()-2);
		}
		return fibList;
	}

}
