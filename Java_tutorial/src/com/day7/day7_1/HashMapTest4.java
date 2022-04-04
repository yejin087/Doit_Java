package com.day7_1;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest4 {
  public static void main(String[] args) {
    HashMap<String, Integer> hm = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    while (true) {

      System.out.println("input words ( to exit type 'x') >>");
      String word = sc.next();

      if (word.toUpperCase().equals("X"))
        break;

      // if (!hm.containsKey(word))
      // hm.put(word, 1);

      // hm.put(word, hm.get(word) + 1);
      // }
      hm.put(word, hm.containsKey(word) == true ? hm.get(word) + 1 : 1);

    }
    System.out.println(hm);
  }
}