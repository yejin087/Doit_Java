package com.day5.ch01_String;

import java.util.StringTokenizer;

public class StringToken1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st = "ȫ�浿,��ȭ/ȫ��/����/���ΰ�";
		StringTokenizer stk = new StringTokenizer(st, ",/");
		System.out.println(stk.countTokens());

		while (stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}

		String tmp = "1 0 15 23 6 21 17 10 11 12 13 14";
		StringTokenizer stk2 = new StringTokenizer(tmp);
		while (stk2.hasMoreTokens()) {
			String str = stk2.nextToken();
			System.out.print(Integer.toHexString(Integer.parseInt(str)) + "//");
			System.out.print(Integer.toOctalString(Integer.parseInt(str)) + "//");
			System.out.print(Integer.toBinaryString(Integer.parseInt(str)) + "//");
			System.out.println();
		}

	}

}
