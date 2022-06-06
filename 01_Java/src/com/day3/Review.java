package com.day3;

public class Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] lotto_num = new int[6];
		
		for( int i = 0 ; i < 6 ; i++) {
			for(int j = 0; j < i ; j++) {
				if(lotto_num[j] == (int)(Math.random()*45 +1)){
					i--;
					break;
				}
			}
	
			lotto_num[i] = (int)(Math.random()*45 +1);
			System.out.printf("$$$%d %d\n",i,lotto_num[i]);
		}
		
		for( int i = 0 ; i < 6 ; i++){	
			System.out.printf(">>> %d %d\n",i,lotto_num[i]);
		}
		int n = 0;
		
		while( n< lotto_num.length) {
			int r = (int)(Math.random()*45+1);
			lotto_num[n] = r;
			
			for (int i = 0 ; i< n ; i++) {
				if(r == lotto_num[i]) {
					n--;
					break;
				}
			}
			
			n++;
		}
	}
}
