package com.mybatis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dto.CommentDTO;
import com.mybatis.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper mapper;

	@Override
	public void insert(CommentDTO comment) {
		mapper.insert(comment);
	}

	@Override
	public List<CommentDTO> getList(int bnum) {

		return mapper.getList(bnum);
	}

	@Override
	public void delete(int cnum) {

		mapper.delete(cnum);

	}

}
