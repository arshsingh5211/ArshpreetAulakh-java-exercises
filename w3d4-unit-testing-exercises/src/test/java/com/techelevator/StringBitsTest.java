
package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class StringBitsTest {
	private StringBits sut;

	@Before
	public void setUp() {
		sut = new StringBits();
	}

	@Test
	public void testBatman() {
		String result = sut.getBits("BSautpmearnm");
		
		assertEquals("Result should return every other character in string starting with the first letter.", "Batman", result);
	}
	
	@Test
	public void testLengthTwoString() {
		String result = sut.getBits("Hi");
		
		assertEquals("Result should return every other character in string starting with the first letter.", "H", result);
	}
	
	@Test
	public void testNumbers() {
		String result = sut.getBits("121212121212");
		
		assertEquals("Result should return every other character in string starting with the first letter.", "111111", result);
	}

}
