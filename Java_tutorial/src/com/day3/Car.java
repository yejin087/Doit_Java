package com.day3;

public class Car {

	String color = "undefined";
	int speed = 0;
	String name = "undefined";

	// default constructor
	public Car() {

	}

	public Car(String color) {
		this.color = color;
	}

	public Car(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public void speedUp(int speed) {
		System.out.println("speed up");
		this.speed += speed;
	}

	public void stop() {
		System.out.println("stop");
		this.speed = 0;
	}

	public int getSpeed() {
		return speed;
	}

	public void info() {
		System.out.println("car name : " + this.name);
		System.out.println("car color : " + this.color);
		System.out.println("car speed : " + this.speed);

	}

}
