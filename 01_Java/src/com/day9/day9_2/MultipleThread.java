package com.day9.day9_2;

public class MultipleThread extends Thread {

  private int table;

  public MultipleThread(int table) {
    this.table = table;
  }

  @Override
  public void run() {
    for (int i = 0; i < table; i++) {
      System.out.println(table + " * " + i + " = " + i * table);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    MultipleThread m1 = new MultipleThread(5);
    m1.start();

    MultipleThread m2 = new MultipleThread(7);
    m2.start();

    MultipleThread m3 = new MultipleThread(8);
    m3.start();
  }
}
