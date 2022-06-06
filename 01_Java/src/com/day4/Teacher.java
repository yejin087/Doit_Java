package com.day4;

import java.util.Scanner;

public class Teacher {

  Student[] st = new Student[50];
  Scanner sc = new Scanner(System.in);
  int row = 0;

  public void inputData() {

    System.out.println("input student score : ");
    System.out.println("id  : ");
    String id = sc.next();
    System.out.println("kor eng math : ");
    int kor = sc.nextInt();
    int eng = sc.nextInt();
    int math = sc.nextInt();

    // nullpoint ?ò§Î•? Î∞úÏÉù
    // st[row].setId(id);
    // st[row].setKor(kor);
    // st[row].setEng(eng);
    // st[row].setMath(math);
    // st[row].setRank(1);

    // st?óê ?ïô?Éù ?†ïÎ≥? ???û•
    st[row++] = new Student(id, kor, eng, math);

  }

  public void viewData() {

    System.out.println("==== view score ==== ");
    // rankmethod();

    for (int i = 0; i < row; i++) {
      System.out.print(st[i].getId() + "\t");
      System.out.print(st[i].getKor() + "\t");
      System.out.print(st[i].getEng() + "\t");
      System.out.print(st[i].getMath() + "\t");
      System.out.print(st[i].getTotal() + "\t");
      System.out.print(st[i].getAvg() + "\t");
      System.out.print(st[i].getRank() + "\t");
      System.out.println();
    }

  }

  public void showMenu() {
    System.out.println("<< select  >>");
    System.out.println("1. input 2. view all / exit");
    System.out.println(" input number >>");
  }

  public void rankmethod() {
    for (int i = 0; i < row - 1; i++) {
      for (int j = i + 1; j < row; j++) {
        if (st[i].getTotal() > st[j].getTotal()) {
          st[j].setRank();
        } else if (st[i].getTotal() < st[j].getTotal()) {
          st[i].setRank();
        }
      }
    }

  }

}