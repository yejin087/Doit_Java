package com.day3.ch01;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;

	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}

	public void take(int fee) {
		this.money += fee;
	}

	public void showInfo() {
		System.out.println(busNumber + " bus have P " + passengerCount + " M " + money);
	}
}
