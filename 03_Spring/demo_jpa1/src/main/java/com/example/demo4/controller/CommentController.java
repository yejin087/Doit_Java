package com.example.demo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo4.config.auth.PrincipalDetails;
import com.example.demo4.model.Board;
import com.example.demo4.model.Comment;
import com.example.demo4.service.CommentService;

@RequestMapping("/comment/*")
@Controller
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("insert/{bnum}")
	@ResponseBody
	public ResponseEntity<String> insert(@PathVariable Long bnum, @RequestBody Comment comment,
			@AuthenticationPrincipal PrincipalDetails principal) {
		// PrincipalDetails p =
		// (PrincipalDetails)SecurityContextHolder.getContext().getAuthentication();
		// set Board
		Board board = new Board();
		board.setNum(bnum);
		comment.setBoard(board);
		// set User
		comment.setUser(principal.getUser());

		// 댓글 추가
		commentService.insert(comment);

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@GetMapping("list")
	@ResponseBody
	public List<Comment> list(Long bnum) {
		return commentService.list(bnum);
	}

	@DeleteMapping("delete/{cnum}")
	@ResponseBody
	public String delete(@PathVariable Long cnum) {
		commentService.delete(cnum);
		return "success";
	}
}
