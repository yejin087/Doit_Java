package com.exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// ArrayList<Student>컬렉션을 만들고,
// 사용자로부터 입력받아 저장하고,
// 학생 이름으 로 검색하는 StudentManager 클래스를 작성하라.

// ① 메뉴선택,학생정보입력,입력한 학생 전체 목록보기,학생 이름으로 찾기,파일로 저장하기 5 개의 메소드를 구현한다.
// ② 메뉴선택 메소드는 static를 사용한다.
// ③ 학생입력 메소드는 한 라인으로 학생정보를 입력받아,로 구분하여 처리한다.
public class StudentManager {

	private ArrayList<Student> s_arr = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	File dir, file;

	public StudentManager() {
		dir = new File("src\\com\\Exam01");
		file = new File(dir, "student.txt");

		try {
			// 파일 없다면 새파일 생성
			if (!(file.exists()))
				file.createNewFile();
			else {
				// 파일이 있다면 이전 내용 로드
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				s_arr = (ArrayList<Student>) ois.readObject();
				ois.close();
			}
		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	// 메뉴 선택
	public static void selectMenu() {
		System.out.println("1.데이터 입력  2.전체 보기 3.학생 찾기 4.저장/종료 ");
	}

	// 학생 정보 입력
	public void studentInsert() {

		while (true) {
			System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요. (입력은 , 로 구분하고 종료는 x) ");

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

	// 입력한 학생 전체 목록 보기
	public void studentView() {
		for (Student student : s_arr) {
			System.out.println(student);
		}
	}

	// 학생 이름으로 찾기
	public void studentSearch() {
		System.out.println("찾을 학생 이름 >>");
		String name = sc.nextLine();

		for (Student student : s_arr) {
			if (student.getName().equals(name)) {
				System.out.println(student);
				break;
			}
		}
	}

	// 파일로 저장하기
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
				System.out.println("저장 후 종료합니다.");
				return;
			} else {
				System.out.println("입력오류");
			}
		}
	}
}