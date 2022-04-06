package com.day6.ch04;

public class Product2 {
	protected int price;
	protected double bonus;

	public Product2(int price) {
		this.price = price;
		this.bonus = price * 0.1;
	}

}

class Computer extends Product2 {
	public Computer(int price) {
		super(price);
	}

	@Override
	public String toString() {
		return "Computer";
	}

}

class TV extends Product2 {
	public TV(int price) {
		super(price);
	}

	@Override
	public String toString() {
		return "TV";
	}

}

class Audio extends Product2 {
	public Audio(int price) {
		super(price);
	}

	@Override
	public String toString() {
		return "Audio";
	}

}
