package com.react.reactmyjwt.payload.request;

import lombok.Getter;
import lombok.Setter;

//User Entitiy를 사용하지 않고 SignupRequest에 따로 복사해서 사용한다
@Getter
@Setter
public class SignupRequest {
	private String username;
	private String email;
	private String password;
	private String role;
}
