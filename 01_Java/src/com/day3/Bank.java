package com.day3;

public class Bank {
	String name;
	int money;

	public Bank() {
	}

	public Bank(String name) {
		this.name = name;
	}

	public Bank(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public void inputMoney(int money) {
		this.money += money;
	}

	public void outputMoney(int money) {

		if (this.money < money) {
			System.out.println("잔액 부족입니다." + Math.abs(this.money - money));
		} else {
			this.money -= money;
		}
	}

	public int getMoney() {
		System.out.println(this.name + " have " + this.money);
		return this.money;
	}

}
