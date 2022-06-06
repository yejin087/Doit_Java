package com.SchoolManagement.test;

import com.SchoolManagement.report.GenerateGradeReport;
import com.SchoolManagement.school.School;
import com.SchoolManagement.school.Score;
import com.SchoolManagement.school.Student;
import com.SchoolManagement.school.Subject;
import com.SchoolManagement.utils.Define;

public class SMTestMain {
	School good_school = School.getInstance();
	Subject korean;
	Subject math;
	Subject dance;

	GenerateGradeReport gradeReport = new GenerateGradeReport();

	public void createSubject() {
		korean = new Subject("����", Define.KOREAN);
		math = new Subject("����", Define.MATH);
		dance = new Subject("��۴�", Define.DANCE);

		dance.setGradeType(Define.PF_TYPE);

		good_school.addSubject(korean);
		good_school.addSubject(math);
		good_school.addSubject(dance);

	}

	// �׽�Ʈ �л� ����
	public void createStudent() {

		Student student1 = new Student(181213, "�ȼ���", korean);
		Student student2 = new Student(181518, "������", math);
		Student student3 = new Student(171230, "�̵�ȣ", korean);
		Student student4 = new Student(171255, "������", korean);
		Student student5 = new Student(171590, "������", math);

		good_school.addStudent(student1);
		good_school.addStudent(student2);
		good_school.addStudent(student3);
		good_school.addStudent(student4);
		good_school.addStudent(student5);

		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);

		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);

		// �� �� ���
		dance.register(student1);
		dance.register(student2);
		dance.register(student3);

		addScoreForStudent(student1, korean, 95);
		addScoreForStudent(student1, math, 56);

		addScoreForStudent(student2, korean, 95);
		addScoreForStudent(student2, math, 95);

		addScoreForStudent(student3, korean, 100);
		addScoreForStudent(student3, math, 88);

		addScoreForStudent(student4, korean, 89);
		addScoreForStudent(student4, math, 95);

		addScoreForStudent(student5, korean, 85);
		addScoreForStudent(student5, math, 56);

		addScoreForStudent(student1, dance, 95);
		addScoreForStudent(student2, dance, 85);
		addScoreForStudent(student3, dance, 55);
	}

	// ���� ���� �Է�
	public void addScoreForStudent(Student student, Subject subject, int point) {

		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);

	}

	public static void main(String[] args) {
		SMTestMain test = new SMTestMain();

		test.createSubject();
		test.createStudent();

		String report = test.gradeReport.getReport(); // ���� ��� ����
		System.out.println(report); // ���

	}
}
