package com.myspring.mysecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.dto.CommentDTO;
import com.myspring.service.CommentService;

@RequestMapping("/reply/*")
@Controller
public class CommentController {

	@Autowired
	CommentService service;

	@PostMapping("commentInsert")
	@ResponseBody
	public String commentInsert(@RequestBody CommentDTO comment) {
		service.insert(comment);
		return "success";
	}

	@GetMapping("commentList/{bnum}")
	@ResponseBody
	public List<CommentDTO> commentList(@PathVariable int bnum) {
		return service.list(bnum);
	}

	@DeleteMapping("commentDelete/{cnum}")
	@ResponseBody
	public int commentDelete(@PathVariable int cnum) {
		if (service.delete(cnum) > 0)
			return cnum;
		return -1;
	}

}
