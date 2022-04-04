package com.day9.day9_3;

public class LambdaThread {
  public static void main(String[] args) {
    // ë¶ˆê??Š¥
    // Runnable runable = new Runnable()

    // interface implements?•˜ì§? ?•Šê³? ë°”ë¡œ êµ¬í˜„?•´?„œ ?‚¬?š©
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
