package com.techelevatorPractice.BankApp;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class SavingsAccountTest {
	
	@Test
	public void getSavingsAccountBalanceAfterTransactions() {
		SavingsAccount sut = new SavingsAccount();
		sut.deposit(new BigDecimal("231.00"));
		sut.withdraw(new BigDecimal("18.00"));
		BigDecimal balanceCheck = sut.getBalance();
		assertEquals("Balance after transactions should be $213.00", 
				0, balanceCheck.compareTo(new BigDecimal ("213.00")));
	}

	@Test
	public void testSavingsAccountWithdrawalCurrentBalanceLessThan150() {
		SavingsAccount sut = new SavingsAccount();
		sut.deposit(new BigDecimal("150.00"));
		//sut.withdraw(new BigDecimal("0.01")); //147.99
		
		assertEquals("If the current balance falls below $150.00 when withdrawal is made an additional $2.00 service fee is implemented.",
				0, sut.withdraw(new BigDecimal("0.01")).compareTo(new BigDecimal("147.99")));
	}
	
	@Test
	public void testSavingsAccountWithdrawalCurrentBalanceEquals150() {
		SavingsAccount sut = new SavingsAccount();
		sut.deposit(new BigDecimal("150.01"));
		
		assertEquals("If the current balance is exactly $150.00 when withdrawal is made, service fee is NOT implemented.",
				0, sut.withdraw(new BigDecimal("0.01")).compareTo(new BigDecimal("150.00")));
	}
	
	@Test
	public void testSavingsAccountWithdrawalCurrentBalanceEqualsAmountToWithdraw() {
		SavingsAccount sut = new SavingsAccount();
		sut.deposit(new BigDecimal("300.00"));
		
		assertEquals("If the current balance falls below $150.00 when withdrawal is made an additional $2.00 service fee is implemented.",
				0, sut.withdraw(new BigDecimal("300.00")).compareTo(new BigDecimal("-2.00")));
	}
	
	@Test
	public void testSavingsAccountWithdrawalCurrentBalanceIsMoreThanAmountToWithdraw() {
		SavingsAccount sut = new SavingsAccount();
		sut.deposit(new BigDecimal("300.00"));
		
		assertEquals("If the current balance remains above $150.00 when withdrawal is made an additional $2.00 service fee is NOT implemented and withdrawal is made.",
				0, sut.withdraw(new BigDecimal("100.00")).compareTo(new BigDecimal("200.00")));
	}
	
	@Test
	public void testSavingsAccountWhenAmountToWithdrawIsZero() {
		SavingsAccount sut = new SavingsAccount();
		
		assertEquals("If the current balance falls below $150.00 when withdrawal is made an additional $2.00 service fee is implemented.",
				0, sut.withdraw(new BigDecimal("00.00")).compareTo(new BigDecimal("0.00")));
	}
	
	@Test
	public void testSavingsAccountWhenAmountToWithdrawSubtractedFromBalanceIsOver150() {
		SavingsAccount sut = new SavingsAccount();
		//sut.deposit(new BigDecimal("00.00"));
		
		assertEquals("If the current balance falls below $150.00 when withdrawal is made an additional $2.00 service fee is implemented.",
				0, sut.withdraw(new BigDecimal("200.00")).compareTo(new BigDecimal("00.00")));
	}

}
