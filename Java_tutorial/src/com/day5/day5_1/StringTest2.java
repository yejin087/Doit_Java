package com.day5_1;

public class StringTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello String";
		System.out.println(str);
		System.out.println("str length : " + str.length());
		System.out.println("'h' position : " + str.indexOf("h"));
		System.out.println("'hello' index :" + str.indexOf("hello"));
		System.out.println("index 4 char :" + str.charAt(4));

		String tmp = "fighting";
		System.out.println("str + tmp concat1 : " + str + tmp);
		System.out.println("str + tmp concat2 : " + str.concat(tmp));

		int value = 7;
		String s = String.valueOf(value);
		System.out.println("str + value concat : " + str.concat(s));
		System.out.println("str + value concat : " + str + value);

		String tmp2 = "aasdf";
		System.out.println("tmp2 upper case : " + tmp2.toUpperCase());
		System.out.println("tmp2 lower case : " + tmp2.toLowerCase());
		System.out.println("tmp2 length : " + tmp2.length());
		System.out.println("tmp2 last alphabet : " + tmp2.charAt(tmp2.length() - 1));
		System.out.println("tmp2 is empty? : " + tmp2.isEmpty());

	}

}
