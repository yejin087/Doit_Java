package com.day9_2;

public class Person2 implements Runnable {

  String name;

  public Person2(String name) {
    this.name = name;
  }

  public void say() {
    for (int i = 0; i < 10; i++) {

      System.out.println(name + "speaks");
    }
  }

  @Override
  public void run() {
    say();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
