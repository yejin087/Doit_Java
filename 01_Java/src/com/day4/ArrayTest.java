package com.day4;

public class ArrayTest {

  public static void main(String[] args) {

    int[][] tmp = new int[3][4];
    tmp[0][0] = 100;
    tmp[0][1] = 200;
    tmp[2][2] = 300;

    // System.out.println(tmp[0].length);

    for (int i = 0; i < tmp.length; i++) {
      for (int j = 0; j < tmp[i].length; j++) {

        System.out.print(tmp[i][j] + "||");
      }

      System.out.println();
    }
  }

}