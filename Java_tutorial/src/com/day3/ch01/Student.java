package com.day3.ch01;

public class Student {
	public String studentName;
	public int grade;
	public int money;

	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}

	public void takeBus(Bus bus) {

		this.money -= 1000;
		bus.take(1000);
		bus.passengerCount += 1;
	}

	public void takeSubway(Subway subway) {
		this.money -= 1500;
		subway.take(1500);

	}

	public void showInfo() {
		System.out.println(studentName + " have " + money);
	}

}
