package com.day6.ch02;

public class Engineer extends Employee {

	private String skillset;

	public Engineer(String name) {
		super(name);
	}

	public String getSkillSet() {
		return skillset;
	}

	public void setSkillSet(String skillset) {
		this.skillset = skillset;
	}

}
