package com.techelevatorPractice.BankApp;

import java.math.BigDecimal;

public class BankCustomer {
	private String name;
	private String address;
	private String phoneNumber;
	private BankAccount[] accounts;
	private boolean isVIP;
	
	public BankCustomer(String fullName, String homeAddress, String phoneNumber) {
		this.name = fullName;
		this.address = homeAddress;
		this.phoneNumber = phoneNumber;
		this.accounts = new BankAccount[] {};
	}
	
	public void addAccount(BankAccount newAccount) {
		int newLen = accounts.length + 1;
		BankAccount [] newAccounts = new BankAccount[newLen];
		for (int i = 0; i < accounts.length; i++) {
			newAccounts[i] = accounts[i];
		}
		newAccounts[newAccounts.length-1] = newAccount;
		accounts = newAccounts;
		// there has to be a better way lol
	}
	
	public BigDecimal getTotalBalance (BankAccount[] allCustomerAccounts) {
		BigDecimal totalBalance = new BigDecimal("0.00");
		for (BankAccount account : accounts) {
			totalBalance = totalBalance.add(account.getBalance());
		}
			return totalBalance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public BankAccount[] getAccounts() {
		return accounts;
	}
	public boolean getIsVIP() {
		return getTotalBalance(getAccounts()).compareTo(new BigDecimal("24999.99")) == 1;
	}

}
