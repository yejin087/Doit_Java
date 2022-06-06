package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo1.dto.BoardDTO;
import com.example.demo1.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {

	@Autowired
	private BoardService bservice;

	@GetMapping("list")
	public void list(Model model) {
		model.addAttribute("board_list", bservice.list());
		model.addAttribute("count", bservice.count());
	}

	@GetMapping("insert")
	public void insertForm() {

	}

	@PostMapping("insert")
	public String insert(BoardDTO board) {
		bservice.insert(board);
		return "redirect:list";
	}

	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		model.addAttribute("board", bservice.view(num));
		return "/board/view";
	}

	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		if (bservice.delete(num) > 0)
			return "success";
		return "fail";
	}

	// 수정폼
	@GetMapping("update/{num}")
	public String updateForm(@PathVariable int num, Model model) {
		model.addAttribute("board", bservice.view(num));
		return "/board/update";
	}

	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody BoardDTO board) {
		bservice.update(board);
		return "success";
	}
}
