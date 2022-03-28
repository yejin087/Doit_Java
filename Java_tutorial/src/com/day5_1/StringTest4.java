package com.day5_1;

public class StringTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "This/is/a/Java";

		String arr[] = msg.split("/");

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[i].length() - 1; j >= 0; j--) {
				System.out.print(arr[i].charAt(j));
			}
			System.out.print(" ");
		}

		System.out.println();
		System.out.println((char) ('A' + 2));

		String str = "Hi.. Glad to meet you";
		for (int i = 0; i < str.length(); i++) {
			System.out.print((char) (str.charAt(i) + 2));
		}
		System.out.println();

		// word substring
		System.out.println(str.substring(str.indexOf("meet"), str.indexOf("meet") + "meet".length()));
		System.out.println(str.substring(str.indexOf("meet")));
		System.out.println(str.indexOf('t'));
		System.out.println(str.lastIndexOf('t'));

	}

}
