package com.react.reactspringjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.react.reactspringjpa.model.Board;
import com.react.reactspringjpa.service.BoardService;

@RestController
public class HomeController {
	@Autowired
	BoardService boardService;

	@PostMapping("api/insert")
	public String insert(@RequestBody Board board) {
		System.out.println("insert");
		boardService.insert(board);
		return "insert";
	}

	@GetMapping("api/list")
	public List<Board> list() {
		return boardService.listAll();
	}

	@GetMapping("api/test")
	public String test() {
		System.out.println("test");
		return "success";
	}

}
