package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {

	private Lucky13 sut;
	
	@Before
	public void setUp(){
		System.out.println("run the test");
		sut = new Lucky13();
	}

	@Test
	public void testAll1sAnd3s() {
		boolean result = sut.getLucky(new int[] {3, 1, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3});
		
		assertEquals("Result should be false because there are all 1s and 3s.", false, result);
	}
	
	@Test
	public void testNo1sOr3s() {
		boolean result = sut.getLucky(new int[] {87878, 25, 26, 476});
		
		assertEquals("Result should be true because there are no 1s and 3s.", true, result);
	}

	@Test
	public void testOnly1sNo3s() {
		boolean result = sut.getLucky(new int[] {11, 1, 1111});
		
		assertEquals("Result should be false because there is a 1.", false, result);
	}
	
	@Test
	public void testNo1sOnly3s() {
		boolean result = sut.getLucky(new int[] {333, 3, 33, 3333, 33333});
		
		assertEquals("Result should be false because there is a 3.", false, result);
	}
	
	@Test
	public void testEmptyArray() {
		boolean result = sut.getLucky(new int[] {});
		
		assertEquals("Result should be true because there are no 1s or 3s.", true, result);
	}
	
	@Test
	public void testOnlyOne() {
		boolean result = sut.getLucky(new int[] {1});
		
		assertEquals("Result should be false because there is a 1.", false, result);
	}
	
	@Test
	public void testOnlyThree() {
		boolean result = sut.getLucky(new int[] {3});
		
		assertEquals("Result should be false because there is a 3.", false, result);
	}
	
	@Test
	public void testDigits1Or3sButNo1sOr3s() { // so many useless tests since i know digits don't matter only ints
		boolean result = sut.getLucky(new int[] {11, 33, 111, 333, 1111, 3333, 11111, 33333});
		
		Assert.assertTrue("Result should be true because there are no 1s or 3s.", result);
	}
}
