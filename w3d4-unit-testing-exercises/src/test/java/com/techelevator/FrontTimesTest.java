package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class FrontTimesTest {
	private FrontTimes sut;
	
	@Before
	public void setUp() {
		System.out.println("run the test");
		sut = new FrontTimes();
	}

	@Test
	public void testFrontTimesSayMyName() {
		String result = sut.generateString("Arsh", 6);
		
		assertEquals("Result should be the first three letters of my name repeated six times.","ArsArsArsArsArsArs", result);
	}
	
	@Test
	public void testFrontTimesShorterThanThreeCharacters() {
		String result = sut.generateString("ab", 4);
	
		assertEquals("When the string is less than three characters, the result should retain the whole string 4 times", "abababab", result );
	}
	
	@Test
	public void testFrontTimesReallyLongString() {
		String result = sut.generateString("why is coding so much fun why do we enjoy it so much why is coding so much fun why do we enjoy it so much why is coding so much fun why do we enjoy it so much why is coding so much fun why do we enjoy it so much why is coding so much fun why do we enjoy it so much", 5);
		
		assertEquals("Result should be the first three letters of the string even in cases of a really long string","whywhywhywhywhy", result);
	}
	
	@Test
	public void testFrontTimesVote() {
		String result = sut.generateString("Vote", 1);
	
		assertEquals("When the string is more than three characters and repeated only once, result should return only the first three letters just once.", "Vot", result );
	}
	
	@Test
	public void testFrontTimesZero() {
		String result = sut.generateString("halkjhalskhjfd", 0);
	
		assertEquals("When the string is repeated zero times, result should return empty.", "", result );
	}

}
