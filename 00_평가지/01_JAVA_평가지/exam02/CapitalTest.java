package com.exam02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CapitalTest {
	private HashMap<String, String> hmap = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);
	private File dir, file;

	public CapitalTest() throws IOException {
		dir = new File("src\\com\\exam02");
		file = new File(dir, "capital.txt");

		if (!(file.exists())) {
			file.createNewFile();
		} else {
			Scanner sc = new Scanner(file);
			// Map�� �߰�
			while (sc.hasNext()) {
				String key = sc.next();
				String value = sc.next();
				hmap.put(key, value);
			}
		}
	}

	static void showMenu() {
		System.out.println("**** ���� ���߱� ������ �����մϴ� ****");
		System.out.println("1.�����Է�  2.����Ǯ�� 3.�������� �� ���� >>");
	}

	public void insertQuiz() {
		String capital;
		String country;

		while (true) {

			System.out.println("����� ����  ( exit -> x");
			country = CapitalTest.sc.next();

			if (country.equalsIgnoreCase("x")) {
				break;
			}

			if (hmap.containsKey(country)) {
				System.out.println("�̹� �����ϴ� �����Դϴ�.");
				continue;
			}

			capital = CapitalTest.sc.next();
			hmap.put(country, capital);
		}
	}

	public void quiz() {

		Set<String> set = hmap.keySet(); // Ű���� ���ϱ�
		Object[] arr = set.toArray();
		String country_prev = null; // ���� ������ ���� ���� �ȳ�����

		while (true) {
			int r = (int) (Math.random() * hmap.size());

			String country = (String) arr[r]; // ������ ������ ����

			if (country == country_prev)
				continue;

			System.out.println(country + "�� ������ ? (���� x) >>");
			String answer = CapitalTest.sc.next();

			// ���� ����
			if (answer.equalsIgnoreCase("x"))
				break;

			if (hmap.get(country).equals(answer)) {
				System.out.println("����.");
			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
			}

			country_prev = country;
		}
	}

	public void save() throws IOException {
		FileWriter fw = new FileWriter(file);
		Set<String> set = hmap.keySet();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String key = it.next();
			String value = hmap.get(key);
			fw.write(key + " ");
			fw.write(value + "\n");
		}

		fw.close();
	}

	public static void main(String[] args) throws IOException {

		CapitalTest ct = new CapitalTest();

		while (true) {
			CapitalTest.showMenu();
			int choice = ct.sc.nextInt();
			switch (choice) {
			case 1:
				ct.insertQuiz();
				break;
			case 2:
				ct.quiz();
				break;
			case 3:
				ct.save();
				System.out.println("���� ������ �����մϴ�.");
				return;
			default:
				System.out.println("�޴��� ���ڸ� �����ϼ���.");

			}
		}
	}

}
