package com.day2;

public class Exam01 {
	public static void main(String[] args) {
//		int num = 1;
//		int sum = 0;
//		
//		while( num%2 ==1){
//			sum += num;
//			
//		}
		
//		
		
		
		int sum = 0;
		for(int i = 1 ; i < 10 ; i++) {
			if(i%2 != 1)
				continue;
			sum += i;
			System.out.println("");
		}
		System.out.println(sum);	
	}
}
