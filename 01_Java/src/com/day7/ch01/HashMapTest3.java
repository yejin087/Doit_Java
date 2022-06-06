package com.day7.ch01;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest3 {
  public static void main(String[] args) {
    HashMap<String, String> hm = new HashMap<>();

    hm.put("java", "1111");
    hm.put("oracle", "1234");
    hm.put("jsp", "abcd");

    Scanner sc = new Scanner(System.in);
    System.out.println(" input id and pw ");
    String id = sc.next();
    String pw = sc.next();

    if (hm.containsKey(id)) {
      if (pw.equals(hm.get(id))) {
        System.out.println("login pass");
      } else {
        System.out.println(hm.get(id));
        System.out.println(pw);
        System.out.println("pw wrong");
      }
    } else {

      System.out.println("id not exist");
    }
  }

}
