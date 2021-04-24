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
		List <Integer> list = getList();
		while (end > getNextInt(list, end)) {
			getNextInt(list, end);
		}
		System.out.println(list.toString().replace("[", "").replace("]", ""));
		

	}
	
	static int getNextInt (List<Integer>list, int endInt) {
		int next = list.get(list.size()-1) + list.get(list.size()-2);
		if (next < endInt) {
			list.add(next);
		}
		return next;
	}
	
	static List<Integer> getList() {
		List<Integer> fibList = new ArrayList<>();
		fibList.add(0);
		fibList.add(1);
		return fibList;
	}

}
