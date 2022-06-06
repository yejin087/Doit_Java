package com.day6.ch04;

import java.util.ArrayList;

class Buyer {
	private int money;
//	private Product2[] p_arr = new Product2[10];
	private ArrayList<Product2> p_arr = new ArrayList<>();
	private int cnt;
	private int point;

	public Buyer(int money) {
		this.money = money;
	}

	public void Buy(Product2 p) {
		p_arr.add(p);
		this.money -= p.price;
		point += p.bonus;
	}

	public void show() {
		int sum = 0;

		for (Product2 p2 : p_arr) {
			sum += p2.price;
			System.out.println("buy product : " + p2.toString());
		}

		System.out.println("total : " + sum);
		System.out.println("point  : " + point);
	}

	public void refund(Product2 p) {
		p_arr.remove(p);
		this.money += p.price;
		this.point -= p.bonus;
	}

}

public class ProductTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer(1000);
		TV t = new TV(200);
		Computer c = new Computer(150);
		Audio a = new Audio(70);

		b.Buy(t);
		b.Buy(c);
		b.Buy(a);
		b.show();

		b.refund(t);
		b.refund(c);
		b.show();
	}

}
