package com.day7_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HashMapTest2 {
  public static void main(String[] args) {
    HashMap<Integer, Integer> h = new HashMap<>();
    int r;
    for (int i = 0; i < 10; i++) {
      r = (int) (Math.random() * 20 + 1);
      if (h.containsValue(r) == true) {

        i--;
        continue;
      }
      h.put(i, r);

    }

    System.out.println(h);
    List<Integer> list = new ArrayList<>(h.values());
    Collections.sort(list);
    System.out.println("AFTER SORT");
    System.out.println(list);
    System.out.println("reverse");
    Collections.reverse(list);
    System.out.println(list);
    System.out.println("MAX vAL : " + Collections.max(list));
    System.out.println("MIN VAl : " + Collections.min(list));

  }

}
