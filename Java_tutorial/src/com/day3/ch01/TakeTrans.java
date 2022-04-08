package com.day3.ch01;

public class TakeTrans {
	public static void main(String[] args) {
		Student james = new Student("James", 50000);
		Student tomas = new Student("Tomas", 10000);

		Bus B100 = new Bus(100);
		james.takeBus(B100);
		james.showInfo();
		B100.showInfo();

		Subway S2 = new Subway("line 2");
		tomas.takeSubway(S2);
		tomas.showInfo();
		S2.showInfo();

		tomas.takeBus(B100);
		tomas.showInfo();
		B100.showInfo();
	}
}
