package com.day2_Array;

public class Array03 {
	public static void main(String[] args) {
		
		int[] r = new int[10];
		
		for(int i = 0; i< 10 ; i++) {
			r[i] = (int)(Math.random()*50+1);
		}
		
		for(int i : r) {
			System.out.print(i + " ");
		}
	}
}
