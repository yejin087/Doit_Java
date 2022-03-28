package com.day6_2;

public class TransTest {

	public static void main(String[] args) {
		Person p1 = new Person("hong", 15000);
		Person p2 = new Person("lee", 10000);

		Bus bus = new Bus(100);
		Subway subway = new Subway("line2");
		Taxi taxi = new Taxi(1234);

//		p1.takeBus(bus, 1000);
//		p1.takeTaxi(taxi, 4500);
		p1.takeTrans(bus, 100);
		p1.takeTrans(taxi, 4500);
		p1.showInfo();

		bus.showInfo();
		taxi.showInfo();

	}

}
