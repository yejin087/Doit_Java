package com.day1_Basic;

import java.util.Scanner;

public class Exam07 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String name;
    String age;

    System.out.println("나이를 입력하세요.");
    age = scan.nextLine();

    System.out.println("이름을 입력하세요.");
    name = scan.nextLine();

    System.out.printf("나이는 %d입니다.%n", age);
    System.out.printf("이름은 %s입니다.%n", name);

    scan.close();
  }

}
