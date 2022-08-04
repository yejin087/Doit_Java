package com.member.model;

public class SMemberDTO {
	private String name;
	private String userid; // primary key
	private String pwd;
	private String email;
	private String phone;
	private int admin;

	public String getName() {
		return name == null ? "" : name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid == null ? "" : userid.trim();
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd == null ? "" : pwd.trim();
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email == null ? "" : email.trim();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone == null ? "" : phone.trim();
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", userid=" + userid + ", pwd=" + pwd + ", email=" + email + ", phone="
				+ phone + ", admin=" + admin + "]";
	}
}
