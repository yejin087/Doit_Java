package com.day1;

import java.util.Scanner;

public class Exam06 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // int num1 = sc.nextInt();
    // int num2 = sc.nextInt();
    // String operator = sc.next();
    // int result = 0;

    // switch (operator) {
    // case "+":
    // result = num1 + num2;
    // break;
    // case "-":
    // result = num1 - num2;
    // break;
    // case "/":
    // result = num1 / num2;
    // break;
    // case "*":
    // result = num1 * num2;
    // break;
    // default:
    // System.out.println("input operator");
    // }
    // System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

    // int h = sc.nextInt();
    // int w = sc.nextInt();

    // System.out.print(h * w * 0.5);

    int min = sc.nextInt();
    int max = sc.nextInt();

    if (min > max) {
      int tmp = min;
      min = max;
      max = tmp;
    }

    System.out.println("min : " + min + "\nmax :" + max);
    sc.close();
  }
}
