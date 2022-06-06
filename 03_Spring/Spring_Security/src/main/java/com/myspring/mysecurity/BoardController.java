package com.myspring.mysecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.dto.BoardDTO;
import com.myspring.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()") // 권한이 있는 사람만 insert.jsp로 이동. 없다면 로그인 창으로 이동
	public void insertForm() {
		// insert.jsp 로 이동
	}

	@PostMapping("insert")
	public String insert(BoardDTO board) {
		service.insert(board);
		return "redirect:/board/list";
	}

	@GetMapping("list")
	public void list(Model model) {
		model.addAttribute("board_list", service.list());
		model.addAttribute("count", service.count());
	}

	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		model.addAttribute("board", service.view(num));
		return "/board/view";
	}

}
