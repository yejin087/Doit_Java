package com.day5.ch02_inheritance;

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
