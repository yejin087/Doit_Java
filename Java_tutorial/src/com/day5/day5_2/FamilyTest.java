package com.day5_2;

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

		Father fa1; // 선언
		Child ch2 = new Child(); // 생성
		fa1 = ch2; // type = Father Class! 범위가 큰 타입에 포함되는 타입을 대입할 수 있다.
		fa1.fatherMethod();
//		fa1.childMethod(); type이 Father class 이므로 childmethod를 사용할 수 없다.
		fa1.grandfatherMethod();

		System.out.println("===");

		// type = Father Class, Father Class처럼 사용가능.
		// child class의 method 사용 불가.
		// 하지만 child class에서 override한 method는 사용가능
		Father fa2 = new Child();
		fa2.method(); // child override method

	}

}
