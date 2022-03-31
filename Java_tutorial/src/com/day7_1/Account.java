package com.day7_1;

public class Account {
  private String name;
  private int money;

  public Account(String name, int money) {
    this.name = name;
    this.money = money;

  }

  public void inputMoney(int money) {
    this.money += money;
  }

  public void output(int money) {

    if (this.money < money) {
      System.out.println("error");
      return;
    }

    this.money -= money;
  }

  public int getMoney() {
    return money;
  }

  public String getName() {
    return name;
  }
}