package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo1.dto.CommentDTO;
import com.example.demo1.mapper.BoardMapper;
import com.example.demo1.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper cmapper;

	@Autowired
	BoardMapper bmapper;

	@Transactional
	@Override
	public void insert(CommentDTO comment) {
		cmapper.insert(comment);
		bmapper.UpdateReplyCnt(comment.getBnum(), 1);
	}

	@Override
	public List<CommentDTO> list(int bnum) {

		return cmapper.list(bnum);
	}

	@Override
	@Transactional
	public int delete(int cnum) {
		CommentDTO comment = cmapper.view(cnum);
		bmapper.UpdateReplyCnt(comment.getBnum(), -1);
		return cmapper.delete(cnum);
	}

}
