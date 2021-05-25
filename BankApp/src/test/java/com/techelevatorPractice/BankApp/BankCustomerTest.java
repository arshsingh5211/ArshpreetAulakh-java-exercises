package com.techelevatorPractice.BankApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class BankCustomerTest {

	@Test
	public void addVIPTest() {
		BankCustomer sut = new BankCustomer("Bruce Wayne", "1007 Mountain Drive, Gotham, NJ 12345", "1-800-Call-Bat");
		SavingsAccount bat = new SavingsAccount();
		bat.deposit(new BigDecimal("2000000000.00"));
		sut.addAccount(bat);
		CheckingAccount bat2 = new CheckingAccount();
		bat2.deposit(new BigDecimal("500500.00"));
		sut.addAccount(bat2);
		assertEquals("There should be two accounts in The Batman's customer profile.", 2, sut.getAccounts().length, 0.1);
		assertEquals("Total Balance of all of Wayne's accounts should be 2,000,500,500.00", 
				0, new BigDecimal("2000500500.00").compareTo(sut.getTotalBalance(sut.getAccounts())));
		assertTrue("Bruce Wayne is Batman. Of course he is a VIP!", sut.getIsVIP());
	}
	
	@Test
	public void addNotImportantPersonTest() {
		BankCustomer sut = new BankCustomer("John Smith", "123 Generic Street", "555-555-5555");
		SavingsAccount s1 = new SavingsAccount();
		s1.deposit(new BigDecimal("2300.00"));
		sut.addAccount(s1);
		CheckingAccount c1 = new CheckingAccount();
		c1.deposit(new BigDecimal("500.00"));
		sut.addAccount(c1);
		assertEquals("There should be two accounts in customer profile.", 2, sut.getAccounts().length, 0.1);
		assertEquals("Total Balance of all of this random generic person's accounts should be 2,800.00", 
				0, new BigDecimal("2800.00").compareTo(sut.getTotalBalance(sut.getAccounts())));
		assertFalse("I already forgot his name, so clearly not a VIP", sut.getIsVIP());
	}
	
	@Test
	public void getCustomerInfoTest() {
		BankCustomer sut = new BankCustomer("John Smith", "123 Generic Street", "555-555-5555");
		sut.setAddress("326 Woof St");
		sut.setName("Laadi Kaur");
		sut.setPhoneNumber("1-800-Tail-Wag");
		assertEquals("Get this very good dog's name.", "Laadi Kaur", sut.getName());
		assertEquals("Get this very good dog's address.", "326 Woof St", sut.getAddress());
		assertEquals("Get this very good dog's number.", "1-800-Tail-Wag", sut.getPhoneNumber());
		assertEquals("Get this very good dog's total balance.", 
				0, sut.getTotalBalance(sut.getAccounts()).compareTo(new BigDecimal("0.00")));
	}

}

