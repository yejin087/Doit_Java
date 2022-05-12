package com.example.demo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

import com.example.demo4.config.auth.PrincipalDetails;
import com.example.demo4.model.Board;
import com.example.demo4.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()") // 권한이 있는 사람만 글을 쓸수 있다
	public String insert() {
		return "/board/insert";
	}

	@PostMapping("insert")
	public String insert(Board board, @AuthenticationPrincipal PrincipalDetails principal) {
		boardService.insert(board, principal.getUser());
		return "redirect:/board/list";
	}

	@GetMapping("list")
	public String list(Model model,
			@PageableDefault(size = 3, sort = "num", direction = Sort.Direction.DESC) Pageable pageable) {
		System.out.println("pageable : " + pageable);
		model.addAttribute("board_list", boardService.list(pageable));
		model.addAttribute("count", boardService.count());
		return "/board/list";
	}

	@GetMapping("view/{num}")
	public String view(@PathVariable Long num, Model model) {
		model.addAttribute("board", boardService.view(num));
		return "/board/view";
	}

	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable Long num) {
		boardService.delete(num);
		return "success";
	}

	@GetMapping("update/{num}")
	public String updateform(@PathVariable Long num, Model model) {
		model.addAttribute("board", boardService.view(num));
		return "/board/update";
	}

	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody Board board) {
		boardService.update(board);
		return "success";
	}

}
