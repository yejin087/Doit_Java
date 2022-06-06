package com.day5.ch02_inheritance;

public class Shape {
	private int x, y;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void print() {
		System.out.println("x , y : " + x + "," + y);
	}

}
