package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CigarPartyTest {
	private CigarParty sut; // subject under test
	

	@Before
	public void setUp() {
		System.out.println("run the test");
		sut = new CigarParty();
		
	}

	@Test
	public void testHaveSuccessfulParty() {
		boolean result = sut.haveParty(58, false);
		
		assertEquals("The party should be successful if the squirrels have more than 40 cigars and less than 60 cigars during the workweek.", true, result);
	}
	
	
	@Test
	public void testHaveUnSuccessfulParty() {
		boolean result = sut.haveParty(30, false);
		
		assertEquals("The party should not be successful if the squirrels have less than 40 cigars regardless of day of the week.", false, result);
	}
	
	@Test
	public void testLotsOfCigarsOnTheWeekend() {
		boolean result = sut.haveParty(675837, true);
		
		assertEquals("The party should be successful if the squirrels have more than 40 cigars on the weekend (with no limit).", true , result);
	}
	
	@Test
	public void testFewCigarsDuringTheWeek() {
		boolean result = sut.haveParty(39, true);
		
		assertEquals("The party should not be successful if the squirrels have less than 40 cigars on the weekend", false, result);
	}
	
	@Test
	public void testLotsOfCigarsDuringTheWeek() {
		boolean result = sut.haveParty(367556, false);
		
		assertEquals("The party should not be successful if the squirrels have too many cigars during the week.", false, result);
	}
}