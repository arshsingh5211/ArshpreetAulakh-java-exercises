package com.techelevatorPractice.BankApp;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BankAccountTest {
	// I used .equals() before realizing it does not compare scale (ex: bigDecimal 7.00 != 7 but when using .compareTo() assertTrue should work
	// but due to laziness I just made sure my correct variables always matched scale
	// from now on will use sut.getBalance().compareTo(correct) == 0;
	// whoops, also accidentally switched around expected and actual values (fixed all the assertEquals ones)
    @Test
    public void testConstructorBalance() {
    	BankAccount sut = new BankAccount();
    	//assertTrue("Balance at constructor should be $0.00", sut.getBalance().compareTo(new BigDecimal("0.00")) == 0);
    	assertEquals("Balance at constructor should be $0", 0, sut.getBalance().compareTo(new BigDecimal("0.00")), 0.01);
    }
   
    @Test
    public void testDepositWhenMoreThanZero() {
    	BankAccount sut = new BankAccount();
    	BigDecimal correct = new BigDecimal("6438764.00");
    	assertTrue("Balance after deposit should be $6,438,764.00", sut.deposit(new BigDecimal("6438764.00")).equals(correct));
    }
    
    @Test
    public void testDepositWhenZero() {
    	BankAccount sut = new BankAccount();
    	BigDecimal correct = new BigDecimal("0.00");
    	assertTrue("Balance after $0 deposit should still be $0.00", 
    			sut.deposit(new BigDecimal("0.00")).equals(correct));
    }
    
    @Test
    public void testWithdrawalOfZero() {
    	BankAccount sut = new BankAccount();
    	BigDecimal correct = new BigDecimal("0.00");
    	assertTrue("Balance after withdrawing from a new account should remain $0.00", 
    			sut.withdraw(new BigDecimal("0.00")).equals(correct)); 
    }
    
    /*
    @Test
    public void testDepositOfLessThanZeroOfNewAccount() {
    	BankAccount sut = new BankAccount();
    	BigDecimal correct = new BigDecimal("0.00");
    	assertTrue("Balance after deposit of negative money should not work and balance should remain the same.", 
    			sut.deposit(new BigDecimal("-3.00")).equals(correct));
    }
    
    -- i do not need this test since withdrawals will always be overridden so i dont need to check for this in parent
    */
    
    @Test
    public void testWithdrawalOf25AfterDepositOf100() {
    	BankAccount sut = new BankAccount();
    	sut.deposit(new BigDecimal("100.00"));
    	BigDecimal correct = new BigDecimal("75.00");
    	assertTrue("Balance after depositing $100 and withdrawing $25 should be $75", sut.withdraw(new BigDecimal("25.00")).equals(correct)); 
    }
    
    /*
    @Test
    public void testWithdrawalWhenBalanceIsZero() { // to cover all branches (i like all green)
    	BankAccount sut = new BankAccount();
    	assertEquals("Balance after withdrawing $100 should still be $0", 
    			0, sut.withdraw(new BigDecimal("100.00")).compareTo(new BigDecimal("0.00")), 0.01);
    }
    
    -- i do not need this test since withdrawals will always be overridden so i dont need to check for this in parent
    */
    
    @Test
    public void testWithdrawalOfZeroAfterDepositOf100() {
    	BankAccount sut = new BankAccount();
    	sut.deposit(new BigDecimal("100.00"));
    	BigDecimal correct = new BigDecimal("100.00");
    	assertTrue("Balance after depositing $100 and withdrawing $25 should be $75", sut.withdraw(new BigDecimal("0.00")).equals(correct)); 
    }
    
    @Test
    public void testWithdrawalOfEntireBalance() {
    	BankAccount sut = new BankAccount();
    	sut.deposit(new BigDecimal("100.00"));
    	assertEquals("Balance after depositing $100 and withdrawing $100 should be $0", 
    			0, sut.withdraw(new BigDecimal("100.00")).compareTo(new BigDecimal("0.00")), 0.01);
    }
    
    @Test
    public void testTransferWhenBalanceIsMoreThanTransfer() {
    	BankAccount sut = new BankAccount();
    	BankAccount destination = new BankAccount();
    	destination.deposit(new BigDecimal("300.00"));
    	sut.deposit(new BigDecimal("1000.00"));
    	sut.transfer(destination, new BigDecimal("750.00"));
    	BigDecimal sutFinalBalance = sut.getBalance();
    	assertEquals("Transfer of $750 FROM an account with $1000 should result in ending balance of $250", 
    			0, sutFinalBalance.compareTo(new BigDecimal("250.00")), 0.01);
    	assertEquals("Transfer of $750 TO an account with $300 should result in ending balance of $1050", 
    			0, destination.getBalance().compareTo(new BigDecimal("1050.00")), 0.01);
    }
    
    @Test
    public void testTransferWhenBalanceIsZero() {
    	BankAccount sut = new BankAccount();
    	BankAccount destination = new BankAccount();
    	sut.transfer(destination, new BigDecimal("1.00"));
    	BigDecimal sutFinalBalance = sut.getBalance();
    	assertEquals("Transfer of $1 FROM an account with $0 balance should result in ending balance of $0", 
    			0, sutFinalBalance.compareTo(new BigDecimal("0.00")), 0.01);
    	assertEquals("Transfer of $1 from an account with a balance less than transfer amount TO an account with 0.00 should result an unsuccessful transfer", 
    			0, destination.getBalance().compareTo(new BigDecimal("0.00")), 0.01);
    }
    
    @Test
    public void testTransferWhenTransferAmountIsMoreThanBalance() {
    	BankAccount sut = new BankAccount();
    	BankAccount destination = new BankAccount();
    	destination.deposit(new BigDecimal("300.00"));
    	sut.deposit(new BigDecimal("1000.00"));
    	sut.transfer(destination, new BigDecimal("1750.00"));
    	BigDecimal sutFinalBalance = sut.getBalance();
    	assertEquals("Transfer of $1750 FROM an account with only $1000 should result in unsuccessful transfer", 
    			0, sutFinalBalance.compareTo(new BigDecimal("1000.00")), 0.01);
    	assertEquals("Transfer of $1750 from an account with a balance less than transfer amount TO an account with $300 should result in ending balance remaining at $300", 
    			0, destination.getBalance().compareTo(new BigDecimal("300.00")), 0.01);
    }
    
    @Test
    public void testTransferWhenTransferAmountEqualsBalance() {
    	BankAccount sut = new BankAccount();
    	BankAccount destination = new BankAccount();
    	destination.deposit(new BigDecimal("300.00"));
    	sut.deposit(new BigDecimal("1000.00"));
    	sut.transfer(destination, new BigDecimal("1000.00"));
    	BigDecimal sutFinalBalance = sut.getBalance();
    	assertEquals("Transfer of $1000 FROM an account with exactly $1000 should result in successful transfer", 
    			0, sutFinalBalance.compareTo(new BigDecimal("0.00")), 0.01);
    	assertEquals("Transfer of $1000 TO an account with $300 should result in ending balance at $1300", 
    			0, destination.getBalance().compareTo(new BigDecimal("1300.00")), 0.01);
    }
    
    @Test
    public void testGetAccountNumber() {
    	BankAccount sut = new BankAccount();
    	sut.setAccountNumber(123456789);
    	assertEquals("Account number is 123456789", 123456789, sut.getAccountNumber(), 0);
    }
}
