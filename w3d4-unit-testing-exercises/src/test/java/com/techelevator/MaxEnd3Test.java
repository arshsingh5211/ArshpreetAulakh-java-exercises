package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Test {
	private MaxEnd3 sut;

	@Before
	public void setUp() {
		System.out.println("run the test");
		sut = new MaxEnd3();
	}
	
	@Test
	public void testMaxEnd3() {
		int[] result = sut.makeArray(new int[] {2, 11, 3});
		
		assertArrayEquals("3 is greater than 2 so new array should be [3, 3, 3]", new int[]{3, 3, 3}, result);
	}
	
	@Test
	public void testBothEndsEqual() {
		int[] result = sut.makeArray(new int[] {26, 6, 26});
		
		assertArrayEquals("Since both ends are equal, new array should be [26, 26, 26]", new int[]{26, 26, 26}, result);
	}

	@Test
	public void testNegativeEndsMax3() {
		int[] result = sut.makeArray(new int[] {-26, 6, 18});
		
		assertArrayEquals("Since one of the ends is negative, new array should be [18, 18, 18]", new int[]{18, 18, 18}, result);
	}
	
	@Test
	public void testZero() {
		int[] result = sut.makeArray(new int[] {3, 11, 0}); // to cover all branches
		
		assertArrayEquals("3 is greater than 0 so new array should be [3, 3, 3]", new int[]{3, 3, 3}, result);
	}
}
