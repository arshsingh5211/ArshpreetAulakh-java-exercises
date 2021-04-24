package com.techelevator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestExercises {

    public static void main(String args[]) {
    	int[] a = new int[] {3, 7, 98, 34, 85, 2, 1};
    	int[] b = new int[] {5, 10, 8, 33, 34, 2, 1};
		if (a.length % 2 == 0) {
			int mid1 = (a.length-1)/2;
			int mid2 = a.length/2;
			int[] midArr = new int[] {a[mid1], a[mid2], b[mid1], b[mid2]};
			System.out.println(Arrays.toString(midArr));
		} 
		else {
			int mid = a.length/2;
			int[] midArr = new int[] {a[mid], b[mid]};
			System.out.println(Arrays.toString(midArr));
		}
		
		List <int[]> listArr = new LinkedList<int[]>();
    	listArr.add(new int[] {3, 7, 23, 98});
    	listArr.add(new int[] {5, 10, 40, 8});
    	listArr.add(new int[] {3, 13, 98});
    	listArr.add(new int[] {5});
    	listArr.add(new int[] {87, 32, 28, 1});
    	
    	int[] midArr = new int[listArr.size()];
    	for (int i = 0; i < listArr.size(); i++) {
    		midArr[i] = getMiddleNumber(listArr.get(i));
    	}
    	System.out.println(Arrays.toString(midArr));
    }
    
    static int getMiddleNumber (int[] arr) {
		if (arr.length % 2 == 0) {
			int mid1 = (arr.length-1)/2;
			int mid2 = arr.length/2;
			return (arr[mid1] + arr[mid2])/2;
		} 
		else {
			int mid = arr.length/2;
			return arr[mid];
		}
    }
}

// nums [3, 4, 5, 2, 1]
// arr  [4, 5, 2, 1, 3]