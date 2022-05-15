package com.hello.hellospring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    private String username;
    private String password;
    private String email;
    private String role;
}
