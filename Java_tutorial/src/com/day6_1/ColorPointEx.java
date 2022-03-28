package com.day6_1;

class Point {
	protected int x;
	protected int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void showPoint() {
		System.out.printf("(%d,%d)\n", x, y);

	}
}

class ColorPoint extends Point {

	String color;

	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	@Override
	public void showPoint() {

		System.out.printf("(%d,%d) %s\n", super.x, super.y, color);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return color + "»ö ÀÇ" + super.x + super.y;
	}
}

public class ColorPointEx {
	public static void main(String[] args) {
		Point p = new Point(3, 4);
		p.showPoint();

		ColorPoint c = new ColorPoint(2, 3, "yellow");
		c.showPoint();

		Point p1 = new ColorPoint(7, 9, "red");
		p1.showPoint();
		System.out.println(p1);
	}
}
