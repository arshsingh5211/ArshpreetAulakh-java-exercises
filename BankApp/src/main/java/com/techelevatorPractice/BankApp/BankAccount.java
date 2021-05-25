package com.techelevatorPractice.BankApp;

import java.math.BigDecimal;

public class BankAccount {
	private BigDecimal balance;
	private int accountNumber;
	
	public BankAccount() {
		this.balance = new BigDecimal("0.00");
	}
	
	public BigDecimal deposit (BigDecimal amountToDeposit) {
		boolean emptyDeposit = amountToDeposit.compareTo(new BigDecimal("0.00")) != 1;
		if (!emptyDeposit) balance = balance.add(amountToDeposit);
		return balance;
	}
	
	public BigDecimal withdraw (BigDecimal amountToWithdraw) {
		balance = balance.subtract(amountToWithdraw);
		return balance;
	}
	
	public void transfer (BankAccount destinationAccount, BigDecimal transferAmount) {
		int transferLessThanOrEqualToBalance = transferAmount.compareTo(balance);
		if (transferLessThanOrEqualToBalance == -1 || transferLessThanOrEqualToBalance == 0) {
			this.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
		}
	}
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}

}

