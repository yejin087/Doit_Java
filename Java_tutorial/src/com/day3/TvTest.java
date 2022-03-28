package com.day3;

class Tv {

	String name;
	int p_year, inch;

	public Tv() {

	}

	public Tv(String name, int year) {
		this.name = name;
		this.p_year = year;
	}

	public Tv(String name, int p_year, int inch) {
		this(name, p_year);
		this.inch = inch;
	}

	public void show() {

		if (inch == 0)
			System.out.println(name + " " + p_year + "year ");
		else
			System.out.println(name + " " + p_year + "year " + inch + "inch");
	}
}

public class TvTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tv t1 = new Tv("LG", 2021, 65);
		t1.show();

		Tv t2 = new Tv("SM", 2020);
		t2.show();

		Tv t3;
		t3 = new Tv("LG", 2022, 55);
		t3.show();

	}

}
