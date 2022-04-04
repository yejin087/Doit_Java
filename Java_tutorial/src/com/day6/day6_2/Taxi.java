package com.day6_2;

public class Taxi extends Trans {
	private int taxiNum;

	public Taxi(int taxiNum) {
		this.taxiNum = taxiNum;
	}

	public void take(int fee) {
//		System.out.println(this.toString());
		super.take(fee);
	}

	@Override
	public String toString() {
		return "Taxi";
	}

	public void showInfo() {
		System.out.println(this.toString());
		super.showInfo();
	}
}
