package com.day7.ch01;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx1 {
  public static void main(String[] args) {
    Vector<Integer> vc = new Vector<>();
    vc.add(5);
    vc.add(-1);

    System.out.println(vc);

    Iterator<Integer> it = vc.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
