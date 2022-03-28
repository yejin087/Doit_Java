package com.day4;

public class Student {
	private String name;
	private int kor, eng, math;
	private int rank = 1;

	// 생성자
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	// getter
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getRank() {
		return rank;
	}

	// 총점메소드
	public int getTotal() {
		return kor + eng + math;
	}

	// 석차 rank 1 증가
	public void setRank() {
		this.rank++;
	}

	// 평균메소드
	public double getAvg() {
		return (kor + eng + math) / 3;
	}

}
