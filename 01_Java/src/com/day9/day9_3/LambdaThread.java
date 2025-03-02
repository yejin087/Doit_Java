package com.day9.day9_3;

public class LambdaThread {
  public static void main(String[] args) {
    // λΆκ??₯
    // Runnable runable = new Runnable()

    // interface implements?μ§? ?κ³? λ°λ‘ κ΅¬ν?΄? ?¬?©
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
