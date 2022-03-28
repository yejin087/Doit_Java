package com.day5_2;

public class ShapeManager {
//	private Circle[] carr = new Circle[10];
//	private Square[] sarr = new Square[10];
	private Shape[] arr = new Shape[10];
	private int cnt;

	public void inputData(int num) {

		System.out.println("input x y : ");
		int x = ShapeTest.sc.nextInt();
		int y = ShapeTest.sc.nextInt();

		if (num == 1) {
			System.out.println("circle radius :");
			int r = ShapeTest.sc.nextInt();
			arr[cnt++] = new Circle(x, y, r);
		} else if (num == 2) {
			System.out.println("sq width height");
			int w = ShapeTest.sc.nextInt();
			int h = ShapeTest.sc.nextInt();
			arr[cnt++] = new Square(x, y, w, h);
		}
	}

	public void viewData() {
		for (int i = 0; i < cnt; i++) {
			arr[i].print();
			System.out.println(arr[i]);
		}
	}

}
