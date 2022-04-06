package com.day2_Array;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		int sum = 0;
//		
//		int num;
//		while(true) {
//			num = sc.nextInt();
//			if (num == -1)
//				break;
//			sum += num;
//		}
//		
//		System.out.println("sum : "+ sum);
//		sc.close();
//		
//		Scanner sc = new Scanner(System.in);
//		int score;
//		int sum = 0;
//		
//		while(true) {
//			score = sc.nextInt();
//			if(score == 0) break;
//			sum += score;
//		}
//		
//		System.out.println("sum : "+ sum);
		
		Scanner sc = new Scanner(System.in);
		int num;
		int sum =0;
		
		while(true){
			num = sc.nextInt();
			
			if(num == -1) break;
			
			if(num%2 == 0)
				sum += num;
			// if (num%2 == -1) continue ;
			
			System.out.printf("%d, %d \n",num, sum);
					
		}
		
		System.out.println(sum);
		sc.close();
	}
}
