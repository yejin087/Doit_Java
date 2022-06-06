package com.day3;

import java.util.Scanner;

class Triangle {

	double height;
	double base;

	public Triangle() {

	}

	public Triangle(double height, double base) {
		this.height = height;
		this.base = base;
	}

	public double getArea() {
		return height * base / 2;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}

public class TriangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Triangle t1 = new Triangle(10.2, 17.3);
//		System.out.println(" triangle area : " + t1.getArea());
//		t1.setBase(7.5);
//		t1.setHeight(11.2);
//		System.out.println(" triangle area : " + t1.getArea());

		Scanner sc = new Scanner(System.in);
		System.out.print("base height >> ");

		double base = sc.nextDouble();
		double height = sc.nextDouble();
		Triangle t2 = new Triangle(base, height);
		System.out.println("area >> " + t2.getArea());

		Triangle t3;
		t3 = new Triangle();
		sc.close();

	}

}
