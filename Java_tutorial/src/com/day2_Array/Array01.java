package com.day2_Array;

import java.util.Scanner;

public class Array01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[5];
		int sum = 0;
		
		for(int i =0 ; i< num.length ; i++) {
			num[i] = sc.nextInt();
			sum += num[i];
		}
		
		
		System.out.println(">>>" + sum);
		for(int i : num) {
			System.out.print(i + "\t");
		}
		
	
		sc.close();
	}


}
