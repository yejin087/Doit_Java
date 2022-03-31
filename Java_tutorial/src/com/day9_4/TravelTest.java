package com.day9_4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TravelTest {
  public static void main(String[] args) {
    Travelcustomer lee = new Travelcustomer("lee", 10, 100);
    Travelcustomer kim = new Travelcustomer("kim", 30, 300);
    Travelcustomer park = new Travelcustomer("park", 40, 400);

    List<Travelcustomer> customerlist = new ArrayList<>();
    customerlist.add(lee);
    customerlist.add(kim);
    customerlist.add(park);

    customerlist.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));

    int total = customerlist.stream().mapToInt(c -> c.getPrice()).sum();
    System.out.println("total price " + total);

    customerlist.stream().filter(c -> c.getAge() >= 20).forEach(c -> System.out.println(c));
  }
}
