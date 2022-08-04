package com.exam01;
//�̸�, �а�, �й�, ���� ������ ���� StudentŬ������ �ۼ��϶�.

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private String dept;
	private String std_id;
	private String score;

	public Student(String name, String dept, String std_id, String score) {
		this.name = name;
		this.dept = dept;
		this.std_id = std_id;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "�̸� :" + name + "\n" + "�а� : " + dept + "\n" + "�й� : " + std_id + "\n" + "���� ��� : " + score + "\n";
	}

}