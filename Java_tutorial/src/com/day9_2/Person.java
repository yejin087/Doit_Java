package com.day9_2;

public class Person extends Thread {

  String name;

  public Person(String name) {
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
  }
}
