package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.dto.CommentDTO;
import com.myspring.mapper.BoardMapper;
import com.myspring.mapper.CommentMapper;

@Service
public class CommentService {

	@Autowired
	CommentMapper cmapper;

	@Autowired
	BoardMapper bmapper;

	@Transactional
	public void insert(CommentDTO comment) {
		cmapper.insert(comment);
		bmapper.updateReplyCnt(comment.getBnum(), 1);
	}

	public List<CommentDTO> list(int bnum) {
		return cmapper.list(bnum);
	}

	@Transactional
	public int delete(int cnum) {
		// cnt ¡Ÿ¿Ã±‚....
		return cmapper.delete(cnum);
	}
}
