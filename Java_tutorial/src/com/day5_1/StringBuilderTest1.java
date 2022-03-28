package com.day5_1;

public class StringBuilderTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hi.. Glad to meet you";
		StringBuilder sb = new StringBuilder(str);

		System.out.println(sb.reverse());
		System.out.println(sb);

		sb.append("java");
		System.out.println(sb);

		sb.insert(0, "oracle ");
		System.out.println(sb);

		sb.replace(0, 3, "databs");
		System.out.println(sb);

		System.out.println(sb.charAt(5));

		StringBuilder sb2 = new StringBuilder();
		sb2.append("test");
		System.out.println(sb2);

		StringBuffer sbf = new StringBuffer();
		sbf.append("add");
		System.out.println(sbf);

	}

}
