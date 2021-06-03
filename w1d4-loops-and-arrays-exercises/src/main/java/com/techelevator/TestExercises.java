package com.techelevator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestExercises {

    public static void main(String args[]) {		
		List <int[]> listArr = new LinkedList<int[]>();
		MiddleWayClass mwc = new MiddleWayClass();
    	listArr.add(new int[] {3, 7, 23, 98});
    	listArr.add(new int[] {5, 10, 40, 8});
    	listArr.add(new int[] {3, 13, 42, 98});
    	listArr.add(new int[] {5});
    	listArr.add(new int[] {87, 13, 13, 1, 2});
    	
    	System.out.println(sum13(new int[] {87, 13, 13, 1, 2}));
    }
    
	public static int sum13(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i] == 13 && nums[i + 1] == 13) i +=2;
			else if (nums[i] == 13 && nums[i + 1] != 13) i++;
			else sum += nums[i];
		}
		if (nums[nums.length-1] != 13) sum += nums[nums.length-1];
		return sum;
	}
}

// can even make this into a command line program to ask users to enter a series of numbers, then make that into an array
// then make those arrays into a list
// once they say theyre done inputting numbers, return the middle array