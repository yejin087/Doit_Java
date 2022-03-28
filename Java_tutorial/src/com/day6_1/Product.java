package com.day6_1;

public class Product {
	protected int price;
	protected double bonus;

	public Product(int price) {
		this.price = price;
		this.bonus = price * 0.1;
	}

}

class Computer extends Product {
	public Computer(int price) {
		super(price);
	}

	@Override
	public String toString() {
		return "Computer";
	}

}

class TV extends Product {
	public TV(int price) {
		super(price);
	}

	@Override
	public String toString() {
		return "TV";
	}

}

class Audio extends Product {
	public Audio(int price) {
		super(price);
	}

	@Override
	public String toString() {
		return "Audio";
	}

}
