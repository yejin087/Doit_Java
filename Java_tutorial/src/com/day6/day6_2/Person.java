package com.day6_2;

import java.util.ArrayList;

public class Person {
	private String stuName;
	private int grade;
	private int money;
	ArrayList<Trans> T_arr = new ArrayList<>();
//	private Trans[] T_arr = new Trans[10];
	private int cnt;

	public Person(String stuName, int money) {
		this.stuName = stuName;
		this.money = money;
	}

//	public void takeBus(Bus b, int fee) {
//		this.money -= fee;
//		b.take(fee);
//		T_arr[cnt++] = b;
//	}
//
//	public void takeTaxi(Taxi t, int fee) {
//		this.money -= fee;
//		t.take(fee);
//		T_arr[cnt++] = t;
//	}
//
//	public void takeSubway(Subway s, int fee) {
//		this.money -= fee;
//		s.take(fee);
//		T_arr[cnt++] = s;
//
//	}

	public void takeTrans(Trans t, int fee) {
		this.money -= fee;
		t.take(fee);
//		T_arr[cnt++] = t;
		T_arr.add(t);
	}

	public void showInfo() {
		System.out.println(this.stuName + "'s money : " + this.money);
		for (int i = 0; i < T_arr.size(); i++) {
			System.out.println("trans : " + T_arr.get(i));
		}
	}
}
