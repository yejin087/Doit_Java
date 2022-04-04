package com.day5_1;

public class StringTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String tmp = "1 0 15 23 6 21 17 10 11 12 13 14";
		System.out.println("tmp length : " + tmp.length());
		System.out.println("tmp last alphabet : " + tmp.charAt(tmp.length() - 1));

		// String.split
		String[] arr = tmp.split(" ");
		System.out.println(arr.length);
		System.out.println(arr[arr.length - 1]);
		for (String string : arr) {
			System.out.print(string + "//");
		}
		System.out.println();

		// Integer Class
		// String Integer to Integer
		int sum = 0;
		for (String string : arr) {
			sum += Integer.parseInt(string);
		}
		System.out.println("Sum of arr : " + sum);
		System.out.println("sum to hex : " + Integer.toHexString(sum).toUpperCase());
		System.out.println("sum to String : " + Integer.toString(sum));

		String hex = "";
		String oct = "";
		String bin = "";
		for (int i = 0; i < arr.length; i++) {
			int v = Integer.parseInt(arr[i]);
			hex += Integer.toHexString(v) + " ";
			oct += Integer.toOctalString(v) + " ";
			bin += Integer.toBinaryString(v) + " ";

		}

		System.out.println("hex : " + hex);
		System.out.println("oct : " + oct);
		System.out.println("bin : " + bin);

	}

}
