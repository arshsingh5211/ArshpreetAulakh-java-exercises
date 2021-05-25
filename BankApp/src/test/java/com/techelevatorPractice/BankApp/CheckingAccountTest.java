package com.techelevatorPractice.BankApp;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class CheckingAccountTest {

	@Test
	public void testWithdrawalFee() {
		CheckingAccount sut = new CheckingAccount();
		sut.deposit(new BigDecimal("500.00"));
		
		assertEquals("There should be an overdraft fee of $10.00 deducted from balance if balance falls below zero.", 
    			0, sut.withdraw(new BigDecimal("600.00")).compareTo(new BigDecimal("-110.00")), 0.01);
	}
	
	@Test
	public void testWithdrawalWithoutWithdrawalFee() {
		CheckingAccount sut = new CheckingAccount();
		sut.deposit(new BigDecimal("500.00"));
		
		assertEquals("There should not be an overdraft fee of $10.00 deducted from balance if balance does not fall below zero.", 
    			0, sut.withdraw(new BigDecimal("500.00")).compareTo(new BigDecimal("00.00")), 0.01);
	}
	
	@Test
	public void testWithdrawalOverdrawnMoreThan100() {
		CheckingAccount sut = new CheckingAccount();
		sut.deposit(new BigDecimal("500.00"));
		
		assertEquals("If checking account is overdrawn by more than $100, don't withdraw anything and just return original balance.", 
    			0, sut.withdraw(new BigDecimal("600.01")).compareTo(new BigDecimal("500.00")), 0.01);
	}
	

}
