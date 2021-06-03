package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {
	private SameFirstLast sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new SameFirstLast();
		System.out.println("run the test");
	}

	@Test
	public void testSameFirstAndLast() {
		boolean result = sut.isItTheSame(new int [] {1,2,2,2,2,2,2,2,2,1});
		
		assertEquals("Result should return true when first and last numbers in array are the same.", true, result);
	}

	@Test
	public void testDifferentFirstAndLast() {
		boolean result = sut.isItTheSame(new int [] {1, 8, 12, 16, 20, 16, 12, 8, 4, 2});
		
		assertEquals("Result should return false when first and last numbers in array are not the same.", false, result);
	}
	
	@Test
	public void testOnlySameTwoIntsInArray() {
		boolean result = sut.isItTheSame(new int [] {125, 125});
		
		assertEquals("Result should return true when both numbers in array are the same.", true, result);
	}
	
	@Test
	public void testOnlyOneIntInArray() {
		boolean result = sut.isItTheSame(new int [] {26});
		
		assertEquals("Result should return true when only numbers is in array.", true, result);
	}
	
	@Test
	public void testEmptyArray() {
		boolean result = sut.isItTheSame(new int [] {});
		
		assertEquals("Result should return false when array is empty.", false, result);
	}
}
