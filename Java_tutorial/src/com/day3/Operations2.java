package com.day3;

public class Operations2 {
	int n1;
	int n2;

	public Operations2() {

	}

	// constructor overload
	public Operations2(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	public void sum() {
		System.out.println("sum : " + (this.n1 + this.n2));
	}

	// method overload
	public void sum(int n1, int n2) {
		System.out.println("sum : " + (n1 + n2));
	}

	public void sub() {
		System.out.println("sub : " + (this.n1 - this.n2));
	}

	public void div() {
		System.out.println("div : " + (this.n1 / this.n2));
	}

	public void mul() {
		System.out.println("mul : " + (this.n1 * this.n2));
	}

	public int divide() {
		return n1 / n2;
	}
}
