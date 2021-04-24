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
			currentChannel = newChannel >= 3 && newChannel <= 18 ? newChannel : currentChannel;
		}
	}
	public void channelUp() {
		if (isOn) {
			currentChannel = currentChannel == 18 ? 3 : currentChannel + 1;
		}
	}
	public void channelDown() {
		if (isOn) {
			currentChannel = currentChannel == 3 ? 18 : currentChannel - 1;
		}
	}
	public void raiseVolume() {
		if (isOn) {
			currentVolume = currentVolume < 10 ? currentVolume + 1 : currentVolume;
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