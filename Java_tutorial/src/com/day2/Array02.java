package com.day2;

import java.util.Scanner;

public class Array02 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		System.out.print("입력 개수 >> ");
//		int len = sc.nextInt();
//
//		int[] num = new int[len];
//		int sum = 0;
//		int max = -1;
//		
//		for (int i = 0; i < num.length; i++) {
//			num[i] = sc.nextInt();
//			sum += num[i];
//			if(max < num[i]) {
//				max = num[i];
//			}
//		}
//
//		for (int i : num) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n>>" + max);
//		System.out.println(">>" + sum);
	
		int[] data = {10,5,90,100,250,30,77};
		int max = -1;
		int sum = 0;
		int idx = -1;
		
		for(int i= 0; i< data.length ; i++) {
			sum += i;
			if( max < data[i]) {
				max = data[i];
				idx = i;
			}
		}
		System.out.println("max : " + max + " idx = " + idx);
		System.out.println("array sum : " + sum);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("찾을 숫자를 입력하세요 >>");
		int find = sc.nextInt();
		int i ;
		
		for(i = 0; i< data.length ;i++) {
			if( find == data[i]) {
				System.out.println("find num at idx " + i );
				break;
			}
		}
		
		if(i == data.length)
			System.out.println("can't find");
		
		sc.close();
		
	}

}

