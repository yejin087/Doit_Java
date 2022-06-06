package com.day5.ch02_inheritance;

public class FamilyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father fa = new Father();
		fa.fatherMethod();
		fa.grandfatherMethod();
		fa.method();

		System.out.println("===");

		Child ch = new Child();
		ch.childMethod();
		ch.fatherMethod();
		ch.grandfatherMethod();
		ch.method();
		System.out.println(ch.value);
		System.out.println("===");

		GrandFather ga = new GrandFather();
		ga.grandfatherMethod();
		ga.method();

		System.out.println("===");

		Father fa1; // ����
		Child ch2 = new Child(); // ����
		fa1 = ch2; // type = Father Class! ������ ū Ÿ�Կ� ���ԵǴ� Ÿ���� ������ �� �ִ�.
		fa1.fatherMethod();
//		fa1.childMethod(); type�� Father class �̹Ƿ� childmethod�� ����� �� ����.
		fa1.grandfatherMethod();

		System.out.println("===");

		// type = Father Class, Father Classó�� ��밡��.
		// child class�� method ��� �Ұ�.
		// ������ child class���� override�� method�� ��밡��
		Father fa2 = new Child();
		fa2.method(); // child override method

	}

}
