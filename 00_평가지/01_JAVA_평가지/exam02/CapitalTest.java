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
			// Map에 추가
			while (sc.hasNext()) {
				String key = sc.next();
				String value = sc.next();
				hmap.put(key, value);
			}
		}
	}

	static void showMenu() {
		System.out.println("**** 수도 맞추기 게임을 시작합니다 ****");
		System.out.println("1.문제입력  2.퀴즈풀기 3.파일저장 및 종료 >>");
	}

	public void insertQuiz() {
		String capital;
		String country;

		while (true) {

			System.out.println("나라와 수도  ( exit -> x");
			country = CapitalTest.sc.next();

			if (country.equalsIgnoreCase("x")) {
				break;
			}

			if (hmap.containsKey(country)) {
				System.out.println("이미 존재하는 나라입니다.");
				continue;
			}

			capital = CapitalTest.sc.next();
			hmap.put(country, capital);
		}
	}

	public void quiz() {

		Set<String> set = hmap.keySet(); // 키값만 구하기
		Object[] arr = set.toArray();
		String country_prev = null; // 이전 문제와 같은 문제 안나오게

		while (true) {
			int r = (int) (Math.random() * hmap.size());

			String country = (String) arr[r]; // 문제로 출제될 나라

			if (country == country_prev)
				continue;

			System.out.println(country + "의 수도는 ? (종료 x) >>");
			String answer = CapitalTest.sc.next();

			// 종료 조건
			if (answer.equalsIgnoreCase("x"))
				break;

			if (hmap.get(country).equals(answer)) {
				System.out.println("정답.");
			} else {
				System.out.println("틀렸습니다.");
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
				System.out.println("문제 저장후 종료합니다.");
				return;
			default:
				System.out.println("메뉴의 숫자를 선택하세요.");

			}
		}
	}

}
