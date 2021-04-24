package com.techelevator;

public class Elevator {
	private int currentFloor;
	private int numberOfFloors;
	private boolean doorOpen;
	
	public Elevator(int totalNumberOfFloors) {
		this.numberOfFloors = totalNumberOfFloors;
		currentFloor = 1;
	}
	
	public void openDoor() {
		doorOpen = true;
	}
	
	public void closeDoor() {
		doorOpen = false;
	}
	
	public void goUp(int desiredFloor) {
		if (!doorOpen) {
			currentFloor = desiredFloor > currentFloor && desiredFloor <= numberOfFloors  ? desiredFloor : currentFloor;
		}
	}
	
	public void goDown(int desiredFloor) {
		if (!doorOpen) {
			currentFloor = desiredFloor < currentFloor && desiredFloor >= 1 ? desiredFloor : currentFloor;
		}
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}
	
}