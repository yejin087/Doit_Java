package com.myspring.mysecurity;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:board/insert";
	}

	@GetMapping("customLogin")
	public void login() {

	}

	@GetMapping("admin")
	public void admin() {

	}

	@GetMapping("manager")
	public void manager() {
	}

	@GetMapping("customLogout")
	public void customLogout() {

	}

	@GetMapping("all")
	public void all() {

	}
}
