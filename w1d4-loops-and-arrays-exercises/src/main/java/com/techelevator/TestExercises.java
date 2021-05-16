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
    	listArr.add(new int[] {87, 32, 28, 1});
    	
    	System.out.println(Arrays.toString(mwc.getMiddleArray(listArr)));
    }
}

// can even make this into a command line program to ask users to enter a series of numbers, then make that into an array
// then make those arrays into a list
// once they say theyre done inputting numbers, return the middle array