package com.day5_2;

public class Square extends Shape {
	private int width;
	private int height;

	public Square(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public void print() {
		System.out.println("Square w/h" + width + " " + height);
		super.print();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Square";
	}
}
