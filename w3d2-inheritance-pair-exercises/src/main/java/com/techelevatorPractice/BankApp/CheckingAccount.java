package com.techelevatorPractice.BankApp;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

	public BigDecimal withdraw (BigDecimal amountToWithdraw) {
		if (super.getBalance().subtract(amountToWithdraw).compareTo(new BigDecimal("-100.00")) == -1) {
			return super.getBalance();
		}
		else if (super.getBalance().compareTo(amountToWithdraw) == -1) {
			return super.withdraw(amountToWithdraw).subtract(new BigDecimal("10.00"));
		}
		else {
			return super.withdraw(amountToWithdraw);
		}
	}
}

// if balance is more than 100 dollars less than withdrawal amount, don't withdraw and balance is unchanged
// else if balance is less than 100 dollars less than withdrawal amount, add the fee
// else return super.withdrawal