package com.day6_2;

public class Subway extends Trans {
	private String lineNumber;

	public Subway(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public void take(int fee) {
		super.take(fee);
	}

	@Override
	public String toString() {
		return "subway";
	}

	public void showInfo() {
		System.out.println(this.toString());
		super.showInfo();
	}

}
