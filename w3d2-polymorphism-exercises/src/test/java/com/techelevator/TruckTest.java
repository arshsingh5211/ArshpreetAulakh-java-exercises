package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.techelevator.TollCalculator.Car;
import com.techelevator.TollCalculator.Truck;

public class TruckTest {

	@Test
	public void getName4AxTest() {
		Truck truck4Ax = new Truck(4);
		assertEquals("Truck (4 axles)", truck4Ax.getName());
	}
	
	@Test
	public void getName6AxTest() {
		Truck truck6Ax = new Truck(6);
		assertEquals("Truck (6 axles)", truck6Ax.getName());
	}
	
	@Test
	public void getName8AxTest() {
		Truck truck8Ax = new Truck(8);
		assertEquals("Truck (at least 8 axles)", truck8Ax.getName());
	}
	
	@Test
	public void getNumOfAxlesTest() {
		Truck truck = new Truck(12);
		assertEquals(12, truck.getNumAxles());
	}

	@Test
	public void CalculateTruck4AxlesTollTest() {
		Truck truck4 = new Truck(4);
		assertEquals(1.00, truck4.calculateToll(25), 0.01);
	}
	
	@Test
	public void CalculateTruck6AxlesTollTest() {
		Truck truck6 = new Truck(6);
		assertEquals(1.13, truck6.calculateToll(25), 0.01);
	}
	
	@Test
	public void CalculateTruck8AxlesTollTest() {
		Truck truck8 = new Truck(8);
		assertEquals(1.20, truck8.calculateToll(25), 0.01);
	}

}
