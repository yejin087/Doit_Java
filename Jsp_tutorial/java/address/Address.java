package com.address;

public class Address {
	private int num;
	private String name;
	private String zipcode;
	private String addr;
	private String tel;

	public Address() {
	}

//	public Address(int num, String name, String zipcode, String addr, String tel) {
//		this.num = num;
//		this.name = name;
//		this.zipcode = zipcode;
//		this.addr = addr;
//		this.tel = tel;
//	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
