package com.day5_3;

public class OverridingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer lee = new Customer(10010, "lee");
		lee.bonusPoint = 1000;

		VipCustomer kim = new VipCustomer(10020, "kim", 12345);
		kim.bonusPoint = 10000;

		int price = 10000;
		System.out.println(lee.getCustomerName() + " pay " + lee.calPrice(price));
		System.out.println(kim.getCustomerName() + " pay " + kim.calPrice(price));

		Customer vc = new VipCustomer(10030, "idk", 2000);
		vc.bonusPoint = 1000;
		System.out.println(vc.getCustomerName() + " pay " + vc.calPrice(price));
		System.out.println("==============");

		System.out.println(kim.showCustomerInfo());
		System.out.println(lee.showCustomerInfo());
		System.out.println(vc.showCustomerInfo());

	}

}
