package com.exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// ArrayList<Student>�÷����� �����,
// ����ڷκ��� �Է¹޾� �����ϰ�,
// �л� �̸��� �� �˻��ϴ� StudentManager Ŭ������ �ۼ��϶�.

// �� �޴�����,�л������Է�,�Է��� �л� ��ü ��Ϻ���,�л� �̸����� ã��,���Ϸ� �����ϱ� 5 ���� �޼ҵ带 �����Ѵ�.
// �� �޴����� �޼ҵ�� static�� ����Ѵ�.
// �� �л��Է� �޼ҵ�� �� �������� �л������� �Է¹޾�,�� �����Ͽ� ó���Ѵ�.
public class StudentManager {

	private ArrayList<Student> s_arr = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	File dir, file;

	public StudentManager() {
		dir = new File("src\\com\\Exam01");
		file = new File(dir, "student.txt");

		try {
			// ���� ���ٸ� ������ ����
			if (!(file.exists()))
				file.createNewFile();
			else {
				// ������ �ִٸ� ���� ���� �ε�
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				s_arr = (ArrayList<Student>) ois.readObject();
				ois.close();
			}
		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	// �޴� ����
	public static void selectMenu() {
		System.out.println("1.������ �Է�  2.��ü ���� 3.�л� ã�� 4.����/���� ");
	}

	// �л� ���� �Է�
	public void studentInsert() {

		while (true) {
			System.out.println("�л� �̸�, �а�, �й�, ������� �Է��ϼ���. (�Է��� , �� �����ϰ� ����� x) ");

			String std_info = sc.nextLine();

			if (std_info.equalsIgnoreCase("x")) {
				break;
			}

			String std_name = std_info.split(",")[0];
			String dept = std_info.split(",")[1];
			String std_id = std_info.split(",")[2];
			String score = std_info.split(",")[3];

			s_arr.add(new Student(std_name, dept, std_id, score));

		}

	}

	// �Է��� �л� ��ü ��� ����
	public void studentView() {
		for (Student student : s_arr) {
			System.out.println(student);
		}
	}

	// �л� �̸����� ã��
	public void studentSearch() {
		System.out.println("ã�� �л� �̸� >>");
		String name = sc.nextLine();

		for (Student student : s_arr) {
			if (student.getName().equals(name)) {
				System.out.println(student);
				break;
			}
		}
	}

	// ���Ϸ� �����ϱ�
	private void saveToFile() throws IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(s_arr);

	}

	public static void main(String[] args) throws IOException {

		StudentManager sm = new StudentManager();

		while (true) {

			StudentManager.selectMenu();
			int num = sm.sc.nextInt();
			sc.nextLine();

			if (num == 1) {
				sm.studentInsert();
			} else if (num == 2) {
				sm.studentView();
			} else if (num == 3) {
				sm.studentSearch();
			} else if (num == 4) {
				sm.saveToFile();
				System.out.println("���� �� �����մϴ�.");
				return;
			} else {
				System.out.println("�Է¿���");
			}
		}
	}
}