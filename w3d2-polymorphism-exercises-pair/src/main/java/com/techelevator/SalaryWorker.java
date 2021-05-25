package com.techelevator;

public class SalaryWorker implements Worker {
	private String firstName;
	private String lastName;
	private double annualSalary;
	
	public SalaryWorker (String firstName, String lastName, double annualSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		return Math.round(annualSalary/52 * 100.00) / 100.00;
	}
	
	
	public double calculateWeeklyPay() {
		return Math.round(annualSalary/52 * 100.00) / 100.00;
	}
	
	// overloads method so if salary worker we would not need the parameter as it doesn't matter how many hours are worked
	
	public double getAnnualSalary() {
		return annualSalary;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}
}
