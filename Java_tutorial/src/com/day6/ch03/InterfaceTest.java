package com.day6.ch03;

interface ShapeArea {
	double area();

	double circum();
}

class Rectangle implements ShapeArea {

	int w, h;

	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return w * h;
	}

	@Override
	public double circum() {
		// TODO Auto-generated method stub
		return 2 * w * h;
	}

}

class SCircle implements ShapeArea {
	int r;

	public SCircle(int r) {
		this.r = r;
	}

	@Override
	public double circum() {
		// TODO Auto-generated method stub
		return 2 * r * 3.14;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 3.14 * r * r;
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeArea rec = new Rectangle(5, 7);
		ShapeArea cir = new SCircle(5);

		System.out.println(cir.area());
		System.out.println(cir.circum());
		System.out.println(rec.area());
		System.out.println(rec.circum());
	}

}
