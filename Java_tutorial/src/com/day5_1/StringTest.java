package com.day5_1;

public class StringTest {
	public static void main(String[] args) {

		String st1 = "hello";
		String st2 = "hello";
		String tmp = new String("hello");

		if (st1 == tmp) {
			System.out.println("str == tmp");
		} else {
			System.out.println("str != tmp");
		}

//		주소 같다...
		if (st1 == st2) {
			System.out.println("str == st2");
		} else {
			System.out.println("str != st2");
		}

		st1 = st1 + st2;
//		주소 다르다 
		if (st1 == st2) {
			System.out.println("str == st2");
		} else {
			System.out.println("str != st2");
		}
	}
}
