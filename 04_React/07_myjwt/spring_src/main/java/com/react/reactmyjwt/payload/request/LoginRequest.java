package com.react.reactmyjwt.payload.request;

import lombok.Getter;
import lombok.Setter;

// User Entitiy를 사용하지 않고 LoginRequest에 따로 복사해서 사용한다
@Getter
@Setter
public class LoginRequest {
	private String username;
	private String password;
}
