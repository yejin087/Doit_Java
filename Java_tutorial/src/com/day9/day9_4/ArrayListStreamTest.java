package com.day9.day9_4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {
  public static void main(String[] args) {
    List<String> sList = new ArrayList<>();
    sList.add("tomas");
    sList.add("edward");
    sList.add("jack");

    Stream<String> stream = sList.stream();
    stream.forEach(s -> System.out.println(s + " "));
    System.out.println();

    sList.stream().sorted().forEach(s -> System.out.println(s + " "));

    sList.stream().map(s -> s.length()).forEach(n -> System.out.println(n + " "));

    sList.stream().filter(s -> s.length() >= 5).forEach(s -> System.out.println(s));
  }
}