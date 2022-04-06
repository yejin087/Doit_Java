package com.day7.ch02;

import java.util.ArrayList;

class MyStack {
  private ArrayList<String> arrayStack = new ArrayList<>();

  public void mypush(String data) {
    arrayStack.add(data);
  }

  public String mypop() {
    int len = arrayStack.size();
    if (len == 0) {
      System.out.println(" stack is empty");
      return null;
    }

    return (arrayStack.remove(len - 1));
  }

}

public class MyStackTest {
  public static void main(String[] args) {
    MyStack stack = new MyStack();

    stack.mypush("A");
    stack.mypush("B");
    stack.mypush("B");

    System.out.println(stack.mypop());
    System.out.println(stack.mypop());
    System.out.println(stack.mypop());
    System.out.println(stack.mypop());

  }
}
