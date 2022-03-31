package com.day9_2;

class StudentThread implements Runnable {
  private String name;
  private SharedBoard board;

  StudentThread(String name, SharedBoard board) {
    this.name = name;
    this.board = board;

  }

  public void run() {

  }
}

class SharedBoard {
  private int sum;

  public void add() {
    int n = sum;
    n += 10;
    sum = n;
    System.out.println(Thread.currentThread().getName() + " : " + sum);
  }

  public int getSum() {
    return sum;

  }

}

public class SynchronizedTest {
  public static void main(String[] args) {
    SharedBoard board = new SharedBoard();
    // StudentThread st = new StudentThread();
  }
}
