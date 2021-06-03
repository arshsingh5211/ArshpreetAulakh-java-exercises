package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class AnimalGroupNameTest {
	
	private AnimalGroupName sut;
	
	

	@Before
	public void setUp() {
		System.out.println("Run the test");
		sut = new AnimalGroupName();
	}

	@Test
	public void testGetLion() {
		String result = sut.getHerd("lIoN");
		
		assertEquals("Result should be the group name when we input the animalName", "Herd", result);
	}
	
	@Test
	public void testGetUnknown() {
		String result = sut.getHerd("Tiger");
		
		assertEquals("Result should be unknown when animal name is not recognized", "unknown", result);
	}
	
	@Test
	public void testLowerCase() {
		String result = sut.getHerd("dog");
		
		assertEquals("Result should still be the group name if the animalName is not capitalized", "Pack", result);
	}
	
	@Test
	public void testAllCaps() {
		String result = sut.getHerd("DEER");
		
		assertEquals("Result should still be the group name if the animalName is not capitalized", "Herd", result);
	}

}
