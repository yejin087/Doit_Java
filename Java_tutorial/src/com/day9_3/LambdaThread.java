package com.day9_3;

public class LambdaThread {
  public static void main(String[] args) {
    // 불가능
    // Runnable runable = new Runnable()

    // interface implements하지 않고 바로 구현해서 사용
    Runnable runable = new Runnable() {
      @Override
      public void run() {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName());
      }
    };

    Thread t1 = new Thread(runable);
    t1.start();

    System.out.println("====");

    Runnable runable2 = () -> System.out.println(Thread.currentThread().getName());
    Thread t2 = new Thread(runable2);
    t2.start();

  }
}
