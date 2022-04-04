package com.day6_2;

public class Trans {
	private int passengerCount;
	private int fee;
	protected int income;

	public Trans() {

	}

	public Trans(int fee) {
		this.fee = fee;
	}

	public void take(int fee) {
		this.income += fee;
		this.passengerCount += 1;
	}

	public void showInfo() {
		System.out.println("passengerCount : " + this.passengerCount);
		System.out.println("income : " + this.income);
	}
}
