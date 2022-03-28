package com.day6_1;

class Buyer {
	private int money;
	private Product[] p_arr = new Product[10];
	private int cnt;
	private int point;

	public Buyer(int money) {
		this.money = money;
	}

	public void Buy(Product p) {
		p_arr[cnt++] = p;
		this.money -= p.price;
		point += p.bonus;
	}

	public void show() {
		int sum = 0;

		for (int i = 0; i < cnt; i++) {
			sum += p_arr[i].price;
			System.out.println("buy product : " + p_arr[i]);
		}

		System.out.println("total : " + sum);
		System.out.println("point  : " + point);
	}

}

public class ProductTest {

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
	}

}
