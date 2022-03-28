package com.day5_2;

import java.util.Scanner;

public class ShapeTest {
	static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("~ select ~");
		System.out.println("1. circle 2. square 3. view 4.exit ");
		System.out.println("input >>");
	}

	public static void main(String[] args) {
//
//		Circle c1 = new Circle(1, 2, 3);
//		c1.print();
//
//		Square s1 = new Square(1, 2, 3, 3);
//		s1.print();

		ShapeManager sm = new ShapeManager();
		while (true) {

			ShapeTest.showMenu();
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
			case 2:
				sm.inputData(menu);
				break;
			case 3:
				sm.viewData();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("input error");
			}
		}

	}
}
