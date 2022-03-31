package com.day7_1;

import java.util.HashMap;

public class HashMapTest {
  public static void main(String[] args) {
    // HashMap<String, String> hm = new HashMap<>();

    // hm.put("one", "first");
    // hm.put("two", "second");
    // System.out.println(hm);
    // System.out.println(hm.size());
    // System.out.println(hm.get("one"));

    HashMap<String, String> h = new HashMap<>();
    h.put("1", "strawberry");
    h.put("2", "strawberry2");
    h.put("3", "strawberry3");
    h.put("4", "strawberry4");

    for (String string : h.keySet()) {
      System.out.println(h.get(string));

    }
    System.out.println(h.values());
  }
}