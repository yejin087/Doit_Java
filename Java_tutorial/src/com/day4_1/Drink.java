package com.day4_1;

public class Drink {

  private String name;
  private int price, count;

  public Drink(String name, int price, int count) {
    this.name = name;
    this.price = price;
    this.count = count;

  }

  public void printDrink() {
    System.out.println(name + "\t" + price + "\t" + count + "\t" + getTotal());

  }

  public int getTotal() {
    return price * count;
  }

}
