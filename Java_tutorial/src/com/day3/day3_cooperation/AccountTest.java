package com.day3_cooperation;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a1 = new Account("hong", 6000);
		a1.inputMoney(5000);
		a1.output(7000);
		a1.getMoney();
		System.out.println(a1.getName());
	}

}
