package com.day3;

public class Person {

  String name;
  String addr;
  String tel;

  public Person() {

  }

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, String addr, String tel) {
    this.name = name;
    this.addr = addr;
    this.tel = tel;
  }

  public void showInfo() {
    System.out.println(this.name + "'s addr :" + this.addr);
    System.out.println(this.name + "'s tel :" + this.tel);
  }

  public void say() {
    for (int i = 0; i < 10; i++) {

      System.out.println(name + "speaks");
    }
  }
}
