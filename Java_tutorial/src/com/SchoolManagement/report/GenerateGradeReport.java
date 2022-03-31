package com.SchoolManagement.report;

import java.util.ArrayList;

import com.SchoolManagement.grade.BasicEvaluation;
import com.SchoolManagement.grade.GradeEvaluation;
import com.SchoolManagement.grade.MajorEvaluation;
import com.SchoolManagement.grade.PassFailEvalutation;
import com.SchoolManagement.school.School;
import com.SchoolManagement.school.Score;
import com.SchoolManagement.school.Student;
import com.SchoolManagement.school.Subject;
import com.SchoolManagement.utils.Define;

public class GenerateGradeReport {
	School school = School.getInstance();
	public static final String TITLE = " Student Score \t\t\n";
	public static final String HEADER = " NAME | ID | MAJOR_S | SCORE  \n";
	public static final String LINE = "------------------------------\n";

	private StringBuffer buffer = new StringBuffer();

	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();

		for (Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}

		return buffer.toString();
	}

	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);

	}

	public void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList();

		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append("|");
			buffer.append(student.getStudentName());
			buffer.append("|");
			buffer.append(student.getStudentId());
			buffer.append("|");
			buffer.append(student.getMajorSubject().getSubjectName() + "\t");
			buffer.append("|");

			getScoreGrade(student, subject.getSubjectId());

			buffer.append("\n");
			buffer.append(LINE);

		}
	}

	public void getScoreGrade(Student student, int subjectId) {
		ArrayList<Score> scoreList = student.getScoreList();
		int majorId = student.getMajorSubject().getSubjectId();

		GradeEvaluation[] gradeEvaluation = { new BasicEvaluation(), new MajorEvaluation(), new PassFailEvalutation() };

		for (int i = 0; i < scoreList.size(); i++) {
			Score score = scoreList.get(i);

			if (score.getSubject().getSubjectId() == subjectId) {
				String grade;

				if (score.getSubject().getGradeType() == Define.PF_TYPE) {
					grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
				} else {
					if (score.getSubject().getSubjectId() == majorId)
						grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
					else
						grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				}
				buffer.append(score.getPoint());
				buffer.append("|");
				buffer.append(grade);
				buffer.append("|");

			}
		}
	}

	public void makeFooter() {
		buffer.append("\n");
	}
}
