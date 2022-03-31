package com.day1;

import java.util.Scanner;

public class Exam05 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String name = sc.next();
    int lan = sc.nextInt();
    int math = sc.nextInt();
    int eng = sc.nextInt();
    double sum = (lan + math + eng);
    double avg = sum / 3;
    System.out.println(name + " : avg = " + avg + ",  sum =" + sum);

    if (avg >= 90) {
      System.out.println("A");
    } else if (avg >= 80) {
      System.out.println("B");
    } else if (avg >= 70) {
      System.out.println("C");
    } else {
      System.out.println("F");
    }
    sc.close();
  }
}
