package com.day3;

public class Person {

	String name;
	String addr;
	String tel;

	public Person() {

	}

	public Person(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public void showInfo() {
		System.out.println(this.name + "'s addr :" + this.addr);
		System.out.println(this.name + "'s tel :" + this.tel);
	}
}
