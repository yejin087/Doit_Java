package com.day5.ch03_override;

public class Customer {
	protected double bonusPoint;
	protected int id;
	protected String name;
	protected String grade;
	protected double bonusRate;

	public Customer() {
		grade = "silver";
		bonusPoint = 0.01;
	}

	public Customer(int id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	public String getCustomerName() {
		return name;
	}

	public int calPrice(int price) {
		bonusPoint += price * bonusRate;
		return price;
	}

	public String showCustomerInfo() {
		return name + " grade " + grade + " bonus " + bonusPoint;
	}
}
