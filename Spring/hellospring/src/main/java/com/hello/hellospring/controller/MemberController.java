package com.hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hello.hellospring.model.Member;
import com.hello.hellospring.model.PrincipalDetails;
import com.hello.hellospring.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("join")
	public String join() {
		return "/member/join";
	}

	@PostMapping("join")
	public void join(@RequestBody Member member) {
		memberService.join(member);
	}

	@GetMapping("login")
	public String loginlabel() {
		return "/member/login";
	}

	@GetMapping("fail")
	public String fail(Model model) {
		model.addAttribute("errorMsg", "로그인 실패");
		return "/member/login";
	}

	@GetMapping("update")
	public String update(Model model, PrincipalDetails principal) {
		Member member = memberService.view(principal.getUsername());
		model.addAttribute("member", member);
		return "/member/update";
	}

}
