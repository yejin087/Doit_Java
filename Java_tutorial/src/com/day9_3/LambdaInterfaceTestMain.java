package com.day9_3;

public class LambdaInterfaceTestMain {
  public static void main(String[] args) {
    LambdaInterfaceTest test = (s) -> System.out.println(s);
    test.test("hello");
  }
}
