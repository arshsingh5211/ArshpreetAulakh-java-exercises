package com.techelevator;

import java.util.List;

public class MiddleWayClass {
	
	/*
	 10. Given a LINKED LISTLIST OF INT ARRAYS OF VARIABLE LENGTH, return a new array containing their middle 
	 elements. if an array is of even length, return the average of the 2 middle elements
	 middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
	 middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
	 middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
	 */
	public int getMiddleNumber (int[] arr) {
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
	    
	public int[] getMiddleArray (List<int[]> listArr) {
		int [] midArr = new int[listArr.size()];
		for (int i = 0; i < listArr.size(); i++) {
			midArr[i] = getMiddleNumber(listArr.get(i));
	    }
	    	return midArr;
	}
}
