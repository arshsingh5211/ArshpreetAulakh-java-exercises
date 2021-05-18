package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techelevator.PackageDelivery.FexEd;

public class FexEdTest {

	@Test
	public void getNameTest() {
		FexEd fe = new FexEd();
		
		assertEquals("FexEd", fe.getName());
	}
	
	@Test
	public void calculateRateTestFexEd() {
		FexEd fe = new FexEd();
		
		assertEquals(20.00, fe.calculateRate(1, 15), 0.01);
		assertEquals(0.000, fe.calculateRate(0, 1), 0.0);
		assertEquals(0.000, fe.calculateRate(1, 0), 0.0);
		assertEquals(20.00, fe.calculateRate(500, 48), 0.01);
		assertEquals(25.00, fe.calculateRate(501, 48), 0.01);
		assertEquals(23.00, fe.calculateRate(500, 49), 0.01);
		assertEquals(28.00, fe.calculateRate(501, 49), 0.01);
		assertEquals(28.00, fe.calculateRate(3212, 532), 0.01);
	}
	
	@Test
	public void getDistanceTest() {
		FexEd fe = new FexEd();
		
		assertEquals(5.00, fe.getDistanceFee(601), 0.01);
	}
	
	@Test
	public void getWeightTest() {
		FexEd fe = new FexEd();
		
		assertEquals(3.00, fe.getWeightFee(49), 0.01);
	}

}
