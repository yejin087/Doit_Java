package com.day3;

public class Student {

	int studentID;
	int grade;
	String name;

	public Student() {

	}

	public Student(String name, int studentID, int grade) {
		this.name = name;
		this.studentID = studentID;
		this.grade = grade;
	}

	public Student(int studentID, String name, int grade) {
//		this.name = name;
//		this.studentID = studentID;
//		this.grade = grade;
		this(name, studentID, grade);
	}

	public void play() {
		System.out.println(this.name + " is playing");
	}

	public void study() {
		System.out.println(this.name + " is studying");
	}

}
