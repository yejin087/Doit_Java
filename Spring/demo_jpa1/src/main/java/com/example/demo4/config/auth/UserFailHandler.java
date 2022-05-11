package com.example.demo4.config.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class UserFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("fail Handler Class :" + exception);

		String errorMsg = null;
		if (exception instanceof BadCredentialsException) {
			errorMsg = "아이디 또는 비밀번호가 일치하지 않습니다";
		} else if (exception instanceof UsernameNotFoundException) {
			errorMsg = "존재하지 않는 사용자입니다";
		} else if (exception instanceof DisabledException) {
			errorMsg = "비활성화된 계정입니다";
		} else if (exception instanceof InternalAuthenticationServiceException) {
			errorMsg = "없는 계정입니다";
		} else if (exception instanceof LockedException) {
			errorMsg = "잠긴 계정입니다";
		} else {
			errorMsg = "fail";
		}

		request.setAttribute("errorMsg", errorMsg);
		request.getRequestDispatcher("/login?error=true").forward(request, response);

	}

}
