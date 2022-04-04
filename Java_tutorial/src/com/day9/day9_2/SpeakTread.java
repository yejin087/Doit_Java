package com.day9.day9_2;

import java.io.IOException;

public class SpeakTread {

  public static void main(String[] args) {

    // Person p1 = new Person("hong");
    // Person p2 = new Person("lee");

    // p2.start();
    // p1.start();

    Person2 p1 = new Person2("hong");
    Person2 p2 = new Person2("lee");
    Thread t1 = new Thread(p1);
    Thread t2 = new Thread(p2);

    t2.start();
    t1.start();

  }
}
