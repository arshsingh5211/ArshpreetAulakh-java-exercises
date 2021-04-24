package com.techelevator;

public class Airplane {
	private String planeNumber; //6 chars
	private int bookedFirstClassSeats;
	private int availableFirstClassSeats; //derived
	private int totalFirstClassSeats;
	private int bookedCoachSeats;
	private int availableCoachSeats; //derived
	private int totalCoachSeats;
	
	public Airplane (String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}
	
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (forFirstClass && totalNumberOfSeats <= getAvailableFirstClassSeats()) {
			bookedFirstClassSeats += totalNumberOfSeats;
			return true;
		}
		else if (!forFirstClass && totalNumberOfSeats <= getAvailableCoachSeats()) {
			bookedCoachSeats += totalNumberOfSeats;
			return true;
		}
		else return false;
	}

	public String getPlaneNumber() {
		return planeNumber;
	}

	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}

	public int getAvailableFirstClassSeats() {
		return totalFirstClassSeats - bookedFirstClassSeats;
	}

	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}

	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}

	public int getAvailableCoachSeats() {
		return totalCoachSeats - bookedCoachSeats;
	}

	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}

}
