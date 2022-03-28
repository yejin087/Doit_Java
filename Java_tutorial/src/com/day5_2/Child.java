package com.day5_2;

public class Child extends Father {
	public Child() {
		System.out.println("child constructor");
	}

	public void childMethod() {
		System.out.println("child Method");
	}

	@Override
	public void method() {
		System.out.println("child modified gf method");

	}
}
