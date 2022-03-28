package com.day2;

public class Exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i = 1; i<=9 ;i ++) {
////			System.out.println(i + "단");
//			for( int j = 3 ; j<= 7; j++) {
//				System.out.printf("%d * %d = %d\t",j,i,j*i);
//			}
//			
//			System.out.println();
//		}
	
//		for(int i = 3; i<=7 ;i += 2) {
//			System.out.println(i + "단");
//			for( int j = 1 ; j<= 9; j ++) {
//				System.out.printf("%d * %d = %d\n",i,j,j*i);
//			}
//
//			System.out.println();
//		}

		
//		int sum = 0;
//		for(int i = 1 ; i <101 ; i++) {
//			sum += i;
//			if(i%10 == 0) {
//				System.out.println((i-9)+"부터 " +i +"까지의 합" + sum);
//				sum = 0;
//			}
//		}
//		
//		System.out.println();
		
//		for(int i = 0 ; i <=9 ; i++ ) {
//			int sum =0;
//			for(int j = 1 ; j <=10 ; j++) {
//				System.out.print(i*10 + j + "  ");
//				sum += i*10 + j;
//			}
//			
//			System.out.println("-> " +sum);
//		}
//
//		System.out.println();
//		
//		for (int i= 1; i <= 100; i+=10) {
//			int sum = 0;
//			int j;
//			for(j = i ; j < i + 10 ; j++){
//				sum += j;
//				System.out.print(j);
//			}
//			
//			System.out.println( "\t" + i +"부터" + j + "까지의 합 = " + sum);
//		}
		
		
//		for(int i =9 ; i>0  ; i -= 2) {
//			for(int j =1 ; j <= i ; j++) {
//				System.out.print(j);
//			}
//			System.out.println();
//		}
		
//		for(int i = 1 ; i<= 7 ; i++) {
//			for(int j = 1 ; j <= i ; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	
		
//		for(int i = 7 ; i > 0 ; i-= 2) {
//			for( int j = 1 ; j <= i ; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//		
		
		for(char i ='z' ; i >= 'a' ; i--) {
			for(char j ='a'; j <= 'z' ; j++) {
				if(i>j) {
					System.out.print("*");
				}else {
					System.out.print(j);
				}
			}
			
			System.out.println();
		}
		
		
			
		
	}

}
