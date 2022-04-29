package com.mybaits.app3;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.model.GuestListVO;
import com.mybatis.model.GuestService;
import com.mybatis.model.GuestVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private GuestService service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "insert";
	}

	@PostMapping("insert")
	@ResponseBody
	public String insert(@RequestBody GuestVO guest, HttpServletRequest req) {
		guest.setIpaddr(req.getRemoteAddr()); // set IP 주소
		service.guestInsert(guest);
		return "success";
	}

	@GetMapping("list")
	@ResponseBody // 전달하고 싶은 객체 전달 가능
	public GuestListVO list(@RequestParam String field, @RequestParam String word) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		// call Service
		List<GuestVO> guest_list = service.guestList(hm);
		int count = service.guestCount(hm);
		GuestListVO guestvo = new GuestListVO(guest_list, count);
		return guestvo;
	}

	// jackson databind
	@GetMapping("view")
	@ResponseBody
	public GuestVO view(@RequestParam(name = "num", required = false) int num) { // call service GuestVO guest =
		GuestVO guest = service.findByNum(num);
		return guest;
	}

//	@GetMapping("view")
//	@ResponseBody
//	public String view(int num) {
//		GuestVO guest = service.findByNum(num);
//		JSONObject obj = new JSONObject();
//		obj.put("name", guest.getName());
//		obj.put("num", guest.getNum());
//		obj.put("content", guest.getContent());
//		obj.put("grade", guest.getGrade());
//		obj.put("created", guest.getCreated());
//		obj.put("ipaddr", guest.getIpaddr());
//		return obj.toJSONString();
//	}

	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		service.guestDelete(num);
		return "success";
	}
}
