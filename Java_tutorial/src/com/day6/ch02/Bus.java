package com.day6.ch02;

public class Bus extends Trans {
	private int busNum;

	public Bus(int busNum) {
		this.busNum = busNum;
	}

	public void take(int fee) {
//		System.out.println(this.toString());
		super.take(fee);
	}

	public String toString() {
		return "Bus";
	}

	public void showInfo() {
		System.out.println();
		System.out.println(this.toString());
		super.showInfo();
	}

}
