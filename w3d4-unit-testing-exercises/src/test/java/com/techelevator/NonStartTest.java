package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NonStartTest {
	private NonStart sut;

	@Before
	public void setUp() {
		sut = new NonStart();
		System.out.println("run the test");
	}

	@Test
	public void testAverageLengthStrings() {
		String result = sut.getPartialString("ABatman V ", "ASuperman");
		
		assertEquals("Test should return both strings combined into one with the first character of each removed.", "Batman V Superman", result);
	}

	@Test
	public void testTwoLengthStrings() {
		String result = sut.getPartialString("Hi", "It");
		
		assertEquals("Test should return both strings combined into one with the first character of each removed.", "it", result);
	}
	
	@Test
	public void testBadlyCapitalizedStrings() {
		String result = sut.getPartialString("YyOu", "xRuLe");
		
		assertEquals("Test should return both strings combined into one with the first character of each removed.", "yOuRuLe", result);
	}
	
	@Test
	public void testEmptyA() {
		String result = sut.getPartialString("", "*Arsh"); // to cover branches
		
		assertEquals("Test should return just the second string with the first character removed.", "Arsh", result);
	}
	
	@Test
	public void testEmptyB() {
		String result = sut.getPartialString("Xhello", ""); // to cover branches
		
		assertEquals("Test should return just the first string with the first character removed.", "hello", result);
	}
}
