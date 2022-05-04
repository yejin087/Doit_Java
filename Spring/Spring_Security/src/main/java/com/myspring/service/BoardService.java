package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.dto.BoardDTO;
import com.myspring.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper mapper;

	// insert
	public void insert(BoardDTO board) {
		mapper.insert(board);
	}
	// list

	public List<BoardDTO> list() {
		return mapper.list();
	}

	public int count() {
		return mapper.count();
	}

	public BoardDTO view(int num) {
		return mapper.view(num);
	}
}
