package com.example.myapp11.retrofit2;

public class Phone {
	private Long id;
	private String name;
	private String tel;
	
	
	public Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
}
