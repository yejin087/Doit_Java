package com.mybatis.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.dto.CommentDTO;
import com.mybatis.model.CommentService;

@RequestMapping("/reply/*")
@RestController // @Controller + @ResponseBody
public class CommentController {

	@Autowired
	private CommentService service;

	// ´ñ±Û Ãß°¡
	@PostMapping("commentInsert")
	public String commentInsert(@RequestBody CommentDTO comment) {
		service.insert(comment);
		return "success";
	}

	@GetMapping("commentList")
	public List<CommentDTO> commentList(int bnum) {
		return service.getList(bnum);
	}

	@DeleteMapping("delete/{num}")
	public int commentDelete(@PathVariable int num) {
		service.delete(num);
		return num;
	}

}
