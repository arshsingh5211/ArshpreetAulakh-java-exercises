package com.techelevator;

public class VolunteerWorker implements Worker {
	private String firstName;
	private String lastName;
	
	public VolunteerWorker(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		return 0;
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
