package com.day1_Basic;

public class Exam01 {
  public static void main(String[] args) {
    // System.out.println("hello");
    // int age = 20;
    String name = "honggil";
    String addr = "busan";
    System.out.println("name : " + name);
    System.out.println("address : " + addr);

    int a = 15;
    int b = 8;
    System.out.println(a + b); // 23
    System.out.print("a+b : " + a + b); // 158
    System.out.println("a/b : " + (a / b)); // int + int = int type

    // 반지름 r=5 원의 넓이?
    int r = 5;
    double radius = 3.14;
    System.out.println("circle : " + (radius * r * r));

    // 100+200 = 300
    System.out.println("100 + " + "200 =" + (100 + 200));
  }
}
