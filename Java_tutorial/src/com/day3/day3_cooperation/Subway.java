package com.day3_cooperation;

public class Subway {
	public String lineNumber;
	public int passengerCount;
	public int money;

	public Subway(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public void take(int fee) {
		this.money += fee;
		this.passengerCount++;
	}

	public void showInfo() {
		System.out.println(lineNumber + " subway have P " + passengerCount + " M " + money);
	}
}
