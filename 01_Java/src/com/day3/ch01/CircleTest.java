package com.day3.ch01;

class Circle {

	String name;
	int r;

	public Circle() {

	}

	public Circle(String name, int r) {
		this.name = name;
		this.r = r;
	}

	public double getArea() {
		return r * r * 3.14;
	}

}

public class CircleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1;
		c1 = new Circle("pizza", 10);
		System.out.println(c1.name + ", area " + c1.getArea());

		Circle c2 = new Circle();
		c2.name = "donut";
		c2.r = 5;
		System.out.println(c2.name + ", area " + c2.getArea());

		System.out.println("total : " + (c2.getArea() + c1.getArea()));

	}

}
