package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.techelevator.TollCalculator.Car;

public class CarTest {
	private Car car = new Car(true);
	
	@Test
	public void getNameWithTrailerTest() {		
		assertEquals("Car (with trailer)", car.getName());
	}
	
	@Test
	public void getNameNoTrailerTest() {
		Car carNoTrailer = new Car(false);
		assertEquals("Car (no trailer)", carNoTrailer.getName());
	}
	
	@Test
	public void getHasTrailerTest() {
		assertTrue(car.getHasTrailer());
	}

	@Test
	public void CalculateCarWithTrailerTollTest() {
		assertEquals(1.50, car.calculateToll(25), 0.01);
	}
	
	@Test
	public void CalculateCarNoTrailerTollTest() {
		Car car2 = new Car(false);
		assertEquals(0.50, car2.calculateToll(25), 0.01);
	}

}
