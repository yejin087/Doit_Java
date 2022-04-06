package com.day7.ch01;

import java.util.ArrayList;

class AccountManager {

  ArrayList<Account> A_arr = new ArrayList<>();

  public void insertAccount(String name, int money) {
    A_arr.add(new Account(name, money));
  }

  public void viewAccount() {
    for (Account account : A_arr) {
      System.out.println(account.getName() + account.getMoney());
    }
  }
}

public class AccountTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    AccountManager am = new AccountManager();

    am.insertAccount("hong", 3000);
    am.insertAccount("lee", 5000);
    am.insertAccount("gang", 10000);

    am.viewAccount();

  }

}
