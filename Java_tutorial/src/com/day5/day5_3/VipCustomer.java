package com.day5_3;

public class VipCustomer extends Customer {
	private int agentId;
	private double saleRate;

	public VipCustomer(int id, String name, int agentId) {
		super(id, name);
		this.agentId = agentId;
		this.saleRate = 0.1;
		super.grade = "vip";
		super.bonusRate = 0.05;
	}

	@Override
	public int calPrice(int price) {
		bonusPoint += price * bonusRate;
		return price - (int) (price * saleRate);
	}
}