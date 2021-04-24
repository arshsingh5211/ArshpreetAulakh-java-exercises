package com.techelevator;

public class Television {
	private boolean isOn;
	private int currentChannel = 3;
	private int currentVolume = 2;
	
	public void turnOff() {
		isOn = false;
	}
	public void turnOn() {
		isOn = true;
		currentChannel = 3;
		currentVolume = 2;
	}
	public void changeChannel(int newChannel) {
		if (isOn) {
			if (newChannel >= 3 && newChannel <= 18) {
				currentChannel = newChannel;
			}
		}
	}
	public void channelUp() {
		if (isOn) {
			if (currentChannel == 18) {
				currentChannel = 3;
			}
			else currentChannel += 1;
		}
	}
	public void channelDown() {
		if (isOn) {
			if (currentChannel == 3) {
				currentChannel = 18;
			}
			else currentChannel -= 1;
		}
	}
	public void raiseVolume() {
		if (isOn) {
			if (currentVolume < 10) {
				currentVolume += 1;
			}
		}
	}
	public void lowerVolume() {
		if (isOn) {
			if (currentVolume > 0) {
				currentVolume -= 1;
			}
		}
	}

	public boolean isOn() {
		return isOn;
	}
	public int getCurrentChannel() {
		return currentChannel;
	}
	public int getCurrentVolume() {
		return currentVolume;
	}
}