package com.day4_1;

import java.util.Scanner;

public class TwoDemScore {

  // 7개의 숫자, 학생 50명
  int[][] arr = new int[50][7];
  Scanner sc = new Scanner(System.in);
  int row = 0;
  int col = 0;

  public void inputData() {

    System.out.println("input student score : ");
    System.out.println("id num  : ");
    int stNum = sc.nextInt();
    System.out.println("kor eng math : ");
    int kor = sc.nextInt();
    int eng = sc.nextInt();
    int math = sc.nextInt();

    arr[row][0] = stNum;
    arr[row][1] = kor;
    arr[row][2] = eng;
    arr[row][3] = math;
    arr[row][4] = kor + eng + math;
    arr[row][5] = arr[row][4] / 4;
    arr[row][6] = 1;
    row++;
  }

  public void viewData() {

    System.out.println("==== view score ==== ");

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + "\t");
      }
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
      for (int j = 0; j < row; j++) {
        if (arr[i][4] > arr[j][4]) {
          arr[j][6]++;
        } else if (arr[i][4] < arr[j][4]) {
          arr[i][6]++;
        }

      }
    }
  }
}
