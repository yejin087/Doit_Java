package com.react.reactmyjwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test/*")
public class TestController {

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String userAccess() {
		return "User Content";

	}

	@GetMapping("/manager")
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String managerAccess() {
		System.out.println("manager");
		return "Manager Content";

	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() {
		return "admin Content";

	}

}
