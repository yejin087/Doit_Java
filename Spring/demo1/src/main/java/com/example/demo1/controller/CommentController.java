package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo1.dto.CommentDTO;
import com.example.demo1.service.CommentService;

@RequestMapping("/comment/*")
@Controller
public class CommentController {

	@Autowired
	CommentService cservice;

	@PostMapping("insert")
	@ResponseBody
	public String insert(@RequestBody CommentDTO comment) {
		cservice.insert(comment);
		return "success";
	}

	@PostMapping("list")
	@ResponseBody
	public List<CommentDTO> list(int bnum) {
		return cservice.list(bnum);
	}

	@DeleteMapping("delete/{cnum}")
	@ResponseBody
	public int delete(@PathVariable int cnum) {
		return cservice.delete(cnum);
	}
}
