package com.techelevator;

import org.junit.Test;

import com.techelevator.TollCalculator.Tank;

public class TankTest {
	private Tank tank = new Tank();

	@Test
	public void CalculateTankTollTest() {
		tank.calculateToll(3763763);
	}

}
