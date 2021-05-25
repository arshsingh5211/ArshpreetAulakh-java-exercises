package com.techelevatorPractice.BankApp;

import java.math.BigDecimal;

public class Bank {
    public static void main( String[] args ) {
    	BankAccount b1 = new BankAccount();
    	BankAccount b2 = new BankAccount();
    	BigDecimal amountToDeposit = new BigDecimal("1.00");
    	BigDecimal newBalance = b2.deposit(amountToDeposit);
    	BigDecimal amountToTransfer = new BigDecimal("0.50");
    	b2.deposit(new BigDecimal("6365389776635.00"));
    	b2.transfer(b1, new BigDecimal("73637.88"));

    	b2.transfer(b1, amountToTransfer);
    	
    	System.out.println("Bank 1 Balance: " + b1.getBalance());
    	System.out.println("Bank 2 Balance: " + b2.getBalance());
    	
    	CheckingAccount c1 = new CheckingAccount();
    	c1.deposit(new BigDecimal("500.00"));
    	System.out.println("\n\nBalance after deposit: " + c1.getBalance());
    	System.out.println("Balance after withdrawal: " + c1.withdraw(new BigDecimal("600.00")));
    	
    	CheckingAccount c2 = new CheckingAccount();
    	c2.deposit(new BigDecimal("500.00"));
    	System.out.println("\n\nBalance after deposit: " + c2.getBalance());
    	System.out.println("Balance after withdrawal: " + c2.withdraw(new BigDecimal("900.00")));
    	
    	CheckingAccount c3 = new CheckingAccount();
    	c3.deposit(new BigDecimal("500.00"));
    	System.out.println("\n\nBalance after deposit: " + c3.getBalance());
    	System.out.println("Balance after withdrawal: " + c3.withdraw(new BigDecimal("00.40")));
    	
    	SavingsAccount s1 = new SavingsAccount();
    	System.out.println("\n\nBalance after deposit: " + s1.deposit(new BigDecimal("150.00")));
    	System.out.println("Balance after withdrawal: " + s1.withdraw(new BigDecimal("0.01")));
    	
    	SavingsAccount s2 = new SavingsAccount();
    	System.out.println("\n\nBalance after deposit: " + s2.deposit(new BigDecimal("31.00")));
    	System.out.println("Balance after withdrawal: " + s2.withdraw(new BigDecimal("18.00")));
    	
    	SavingsAccount s3 = new SavingsAccount();
    	System.out.println("\n\nBalance after deposit: " + s3.deposit(new BigDecimal("0.00")));
    	System.out.println("Balance after withdrawal: " + s3.withdraw(new BigDecimal("18.00")));
    	
    	BankCustomer sut = new BankCustomer("Bruce Wayne", "1007 Mountain Drive, Gotham, NJ 12345", "1-800-Call-Bat");
		BankAccount bat = new BankAccount();
		bat.deposit(new BigDecimal("2000000000.00"));
		sut.addAccount(bat);
		
		System.out.println("How many accounts does Bruce Wayne have: " + sut.getAccounts().length);
		System.out.println("What is his total balance? " + sut.getTotalBalance(sut.getAccounts()));
		System.out.println("What is Bat Account's total balance? " + bat.getBalance());
    }
}
