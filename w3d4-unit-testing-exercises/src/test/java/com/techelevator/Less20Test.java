package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class Less20Test {
	
	private Less20 sut;

	@Before
	public void setUp() {
		System.out.println("run the test");
		sut = new Less20();
		
	}

	@Test
	public void test38LessThanMultipleOf20() {
		boolean result = sut.isLessThanMultipleOf20(38);
		
		assertEquals("Result should return true because 38 is 2 less than a multiple of 20.", true, result);
	}
	
	@Test
	public void test500IsNotLessThanMultipleOf20() {
		boolean result = sut.isLessThanMultipleOf20(500);
		
		assertEquals("Result should return false because 50 is not 1 or 2 less than a multiple of 20.", false, result);
	}
	
	@Test
	public void test69IsNotLessThanMultipleOf20() {
		boolean result = sut.isLessThanMultipleOf20(89);
		
		assertEquals("Result should return false because 89 is not 1 or 2 less than a multiple of 20.", false, result);
	}

	@Test
	public void test19IsLessThanMultipleOf20() {
		boolean result = sut.isLessThanMultipleOf20(19);
		
		assertEquals("Result should return true because 19 is 1 less than a multiple of 20.", true, result);
	}
	
	@Test
	public void test8IsNotLessThanMultipleOf20() {
		boolean result = sut.isLessThanMultipleOf20(8);
		
		assertEquals("Result should return false because 8 is 12 less than a multiple of 20, not 1 or 2 less.", false, result);
	}
}
