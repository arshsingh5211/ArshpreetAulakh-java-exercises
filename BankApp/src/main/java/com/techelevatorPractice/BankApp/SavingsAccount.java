package com.techelevatorPractice.BankApp;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
	
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		BigDecimal proposedWithdrawal = super.getBalance().subtract(amountToWithdraw);
		boolean accountOverdrawn = (proposedWithdrawal.compareTo(new BigDecimal("0.00")) == -1);
		boolean emptyWithdrawal = amountToWithdraw.compareTo(new BigDecimal("0.00")) != 1; //|| super.getBalance().compareTo(new BigDecimal("0.00")) != 1;
		if (!emptyWithdrawal) { 								// if you try to withdraw 0 or less than zero nothing happens
			if (!accountOverdrawn && proposedWithdrawal.compareTo(new BigDecimal("150.00")) == -1) { 	//if the balance - withdrawal is less than 150 enact service fee
				return super.withdraw(amountToWithdraw).subtract(new BigDecimal("2.00"));
			}
			else if (super.getBalance().compareTo(amountToWithdraw) != -1) { 							// else if balance is greater than amount to withdraw do it normally
				return super.withdraw(amountToWithdraw);
			}
		}
		return super.getBalance();
	}
}


/*
If the current balance is less than $150.00 when a withdrawal is made, 
	an additional $2.00 service charge is withdrawn from the account.
If a withdrawal is requested for more than the current balance, the withdrawal fails and balance remains the same.
*/
