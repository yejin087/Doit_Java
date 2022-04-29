package com.myguest.app2;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myguest.model.GuestDTO;
import com.myguest.model.GuestService;

@Controller
public class GuestController {

	@Autowired
	private GuestService service;

	@PostMapping("ginsert")
	public String insert(GuestDTO guest, HttpServletRequest req) {
		guest.setIpaddr(req.getRemoteAddr());
		service.guestInsert(guest);
		return "redirect:glist";
	}

	@GetMapping("glist")
	public String list(String field, String word, Model model) {

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		model.addAttribute("guestlist", service.guestList(hm));
		model.addAttribute("count", service.guestCount(hm));
		return "list";
	}

	@GetMapping("gview")
	public String view(int num, Model model) {
		model.addAttribute("guest", service.findByNum(num));
		return "view";
	}

	@GetMapping("gupdate")
	public String update_view(int num, Model model) {
		model.addAttribute("guest", service.findByNum(num));
		return "update";
	}

	@PostMapping("gupdate")
	public String update(GuestDTO guest) {
		service.guestUpdate(guest);
		return "redirect:glist";
	}

	@GetMapping("gdelete")
	public String delete(int num) {
		service.guestDelete(num);
		return "redirect:glist";
	}
}
