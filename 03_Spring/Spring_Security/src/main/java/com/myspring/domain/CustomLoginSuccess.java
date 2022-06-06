package com.myspring.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccess implements AuthenticationSuccessHandler {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String encPwd = passwordEncoder.encode(request.getParameter("password"));
		System.out.println("password : " + encPwd);

		List<String> roleNames = new ArrayList<>();
		authentication.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
		System.out.println("roleNames : " + roleNames);
//
//		if (roleNames.contains("ROLE_ADMIN")) {
//			response.sendRedirect("/mysecurity/admin");
//			return;
//		}
//
//		if (roleNames.contains("ROLE_MANAGER")) {
//			response.sendRedirect("/mysecurity/manager");
//			return;
//		}
//		response.sendRedirect("/mysecurity");

		response.sendRedirect("/mysecurity/board/list");

	}

}
