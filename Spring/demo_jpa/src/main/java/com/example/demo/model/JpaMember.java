package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity // Class이름으로 Table이 만들어진다
public class JpaMember {
	@Id // key 설정.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 기능
	private Long id;
	private String name;
	private String password;
	private String email;
	@Column(name = "address")
	private String addr;
	private String memo;

}
