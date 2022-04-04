package com.day5_1;

import java.util.StringTokenizer;

public class StringToken2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tmp = "1 0 15 23 6 21 17 10 11 12 13 14";
		StringTokenizer stk = new StringTokenizer(tmp);
		StringBuilder hex = new StringBuilder();

		while (stk.hasMoreTokens()) {
			String st = stk.nextToken();
			int st_to_int = Integer.parseInt(st);
			hex.append(Integer.toHexString(st_to_int).toUpperCase() + " ");
		}

		System.out.println(hex);
	}

}
