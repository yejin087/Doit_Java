package com.day3;

public class StudentScore {
	String name;
	int kor;
	int math;
	int avg;
	int total;

	public StudentScore(String name, int kor, int math) {
		this.name = name;
		this.kor = kor;
		this.math = math;
	}

	public int getTotal() {
		return kor + math;
	}

	public float getAvg() {
		return getTotal() / 2.0f;
	}
}
