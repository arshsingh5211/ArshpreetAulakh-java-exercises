package com.techelevator;

public class HourlyWorker implements Worker {
	private String firstName;
	private String lastName;
	private double hourlyRate;
	
	public HourlyWorker (String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double pay = Math.round(hourlyRate * hoursWorked * 100.00) / 100.00;
		int overtimeHours = hoursWorked - 40;
		if (overtimeHours > 0) pay += (hourlyRate * overtimeHours * 0.5);
		return Math.round(pay * 100.00) / 100.00;
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}
	
	public double getHourlyRate () {
		return hourlyRate;
	}
}
