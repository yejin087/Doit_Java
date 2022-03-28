package com.day4;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherMain {
	public static Scanner sc = new Scanner(System.in);
	// �迭 �̸� : arr
	ArrayList<Student> arr = new ArrayList<>();
//	Student[] arr = new Student[50];
	int cnt;

	public static void showMenu() {
		System.out.println("�����ϼ���>>");
		System.out.println("1.�Է� 2.��ü����/����");
		System.out.println("����>>");
	}

	public void inputData() {
		System.out.println("�����Է�>>");
		System.out.println("�̸� >>");
		String name = sc.next();
		System.out.println("���� ���� ���� >>");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		// arr ù��°�� �л� ���� ����
//		arr[cnt++] = new Student(name, kor, eng, math);
		// arraylist
		arr.add(new Student(name, kor, eng, math));
	}

	public void viewData() {
		rankMethod();
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == null)
//				break;
//			System.out.println("�̸� : " + arr[i].getName());
//			System.out.println("���� : " + arr[i].getKor());
//			System.out.println("���� : " + arr[i].getEng());
//			System.out.println("���� : " + arr[i].getMath());
//			System.out.println("���� :" + arr[i].getTotal());
//			System.out.println("��� :" + arr[i].getAvg());
//			System.out.println("���� : " + arr[i].getRank());
//			System.out.println();
//		}
		int sum = 0;
		for (Student student : arr) {
			System.out.println("�̸� : " + student.getName());
			System.out.println("���� : " + student.getKor());
			System.out.println("���� : " + student.getEng());
			System.out.println("���� : " + student.getMath());
			System.out.println("���� :" + student.getTotal());
			sum += student.getTotal();
			System.out.println("��� :" + student.getAvg());
			System.out.println("���� : " + student.getRank());
			System.out.println();

		}
		System.out.println("class total " + sum + " avg " + sum / arr.size());

	}

	private void rankMethod() {
//		for (int i = 0; i < cnt - 1; i++) {
//			for (int j = i + 1; j < cnt; j++) {
//				if (arr[i].getTotal() > arr[j].getTotal()) {
//					arr[j].setRank(); // rank�� 1�����ϴ� �޼ҵ�
//				} else if (arr[i].getTotal() < arr[j].getTotal()) {
//					arr[i].setRank();
//				}
//			}
//		}

		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i + 1; j < cnt; j++) {
				if (arr.get(i).getTotal() > arr.get(j).getTotal()) {
					arr.get(j).setRank(); // rank�� 1�����ϴ� �޼ҵ�
				} else if (arr.get(i).getTotal() < arr.get(j).getTotal()) {
					arr.get(i).setRank();
				}
			}
		}

	}

	public static void main(String[] args) {
		TeacherMain t = new TeacherMain();
		while (true) {
			TeacherMain.showMenu();
			int num = sc.nextInt();
			switch (num) {
			case 1:
				t.inputData();
				break;
			case 2:
				t.viewData();
				System.exit(0); // ����
			default:
				System.out.println("�Է¿���");
			} // switch
		} // while
	} // main

} // class
