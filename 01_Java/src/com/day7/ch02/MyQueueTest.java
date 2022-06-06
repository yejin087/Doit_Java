package com.day7.ch02;

import java.util.ArrayList;

class MyQueue {
  ArrayList<String> arrayQ = new ArrayList<>();

  public void enQueue(String data) {
    arrayQ.add(data);
  }

  public String deQueue() {
    int len = arrayQ.size();
    if (len == 0) {
      System.out.println("queue is empty");
      return null;
    }

    return arrayQ.remove(0);
  }
}

public class MyQueueTest {
  public static void main(String[] args) {
    MyQueue mq = new MyQueue();
    mq.enQueue("A");
    mq.enQueue("B");
    mq.enQueue("B");
    mq.enQueue("C");

    System.out.println(mq.deQueue());
    System.out.println(mq.deQueue());
    System.out.println(mq.deQueue());
    System.out.println(mq.deQueue());
    System.out.println(mq.deQueue());
  }
}
