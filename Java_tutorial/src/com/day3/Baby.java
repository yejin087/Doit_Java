package com.day3;

public class Baby {
	String name;
	int age;

	public Baby() {
		System.out.println("constructor");
	}

	public void smile() {
		System.out.println(name + "smile");
	}

	public void cry() {
		System.out.println(name + "crying");
	}

}
