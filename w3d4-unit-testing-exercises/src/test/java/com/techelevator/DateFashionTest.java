package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DateFashionTest {
	private DateFashion sut; //first thing
	
	@Before
	public void setUp() { 
		sut = new DateFashion();
	}

	@Test
	public void testFashionRatingOfTwoOrLower() {
		int result = sut.getATable(3, 2);
		
		assertEquals("If either my date or I have a fashion rating of 2, we will not get a table.", 0, result);
	}
	
	@Test
	public void testFashionRatingofEightOrHigher() {
		int result = sut.getATable(10, 9);
		
		assertEquals("If both date and I have a fashion rating of 8 or higher, we will get a table.", 2, result);
	}
	
	@Test
	public void testSignificantFashionContrast() {
		int result = sut.getATable(10, 0);
		
		assertEquals("If either my date or I have a fashion rating of 2 or less and the other is 8 or higher, we will not get a table.", 0, result);
	}
	
	@Test
	public void testWeBothHaveAverageFashion() {
		int result = sut.getATable(5, 5);
		
		assertEquals("If both my date and I have a fashion rating of 5, we might get a table.", 1, result);
	}
	
	@Test
	public void testHighFashionSettlingforAverageFashion() {
		int result = sut.getATable(10, 5);
		
		assertEquals("If one of us has a fashion rating of less than 8 but more than 2, and the other has a fashion rating higher than 8, we will get a table.", 2, result);
	}
	
	@Test
	public void testAverageFashionSettlingforBadFashion() {
		int result = sut.getATable(0, 5);
		
		assertEquals("If one of us has a fashion rating of less than 8 but more than 2, and the other has a fashion rating of 2 or lower, we will not get a table.", 0, result);
	}
	
	@Test
	public void OneofUsHasBadFashion() {
		int result = sut.getATable(10, 5);
		
		assertEquals("If one of us has a fashion rating of less than 8 but more than 2, and the other has a fashion rating higher than 8, we will get a table.", 2, result);
	}
	
	@Test
	public void OneofUsHighFashion() { // just did this to cover all branches
		int result = sut.getATable(5, 10);
		
		assertEquals("If one of us has a fashion rating between 3 and 8, and the other has a fashion rating higher than 8, we will get a table.", 2, result);
	}
}