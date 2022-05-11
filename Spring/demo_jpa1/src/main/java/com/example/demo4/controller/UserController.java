package com.example.demo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo4.model.User;
import com.example.demo4.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("login")
	public String login(@RequestParam(value = "error", required = false) String error) {
		return "/user/login";
	}

	@PostMapping("login")
	public String login() {
		return "/board/insert";
	}

	@GetMapping("register")
	public String register() {
		return "/user/join";
	}

	// 회원가입
	@PostMapping("register")
	@ResponseBody
	public String register(@RequestBody User user) {
		System.out.println("aa  : " + userService.findByUsername(user.getUsername()));

		if (userService.findByUsername(user.getUsername()) != null)
			return "fail";

		userService.reigster(user);
		return "success";

	}

}
