package com.day5.ch02_inheritance;

public class Circle extends Shape {
	private int r;

	public Circle(int x, int y, int r) {
		super(x, y);
		this.r = r;
	}

	@Override
	public void print() {
		System.out.println("circle r : " + r);
		super.print();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle";
	}
}
