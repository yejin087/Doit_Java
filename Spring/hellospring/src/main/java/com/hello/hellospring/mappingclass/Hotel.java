package com.hello.hellospring.mappingclass;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.tomcat.jni.Address;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@Enumerated(EnumType.STRING)
	private Grade grade;
	@Embedded
	private Address address;

	@OneToMany(mappedBy = "hotel")
	private List<Review> reviews;
}
