package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.JpaMember;
import com.example.demo.service.MemberService;

@Controller
public class HomeController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("join")
	public String join() {
		return "join";
	}

	@PostMapping("join")
	public String join(JpaMember member) {
		memberService.save(member);
		return null;
	}

	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("list", memberService.list());
		return "list";
	}
}
