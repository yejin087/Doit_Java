package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("test.go")
	public String test() {
		return "result"; // view(jsp) ÀÇ¹Ì
	}

	@RequestMapping("result2.go")
	public void test1() {
		// void => result2.jsp
	}
}
