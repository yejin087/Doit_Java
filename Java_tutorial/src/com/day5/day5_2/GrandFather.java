package com.day5_2;

public class GrandFather {
	protected String value = "Have property";

	public GrandFather() {
		System.out.println("grandfa constructor");
	}

	public void grandfatherMethod() {
		System.out.println("grandfather Method");
	}

	public void method() {
		System.out.println("method from gf");
	}
}
