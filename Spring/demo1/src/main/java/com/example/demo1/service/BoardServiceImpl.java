package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.dto.BoardDTO;
import com.example.demo1.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper bmapper;

	@Override
	public void insert(BoardDTO board) {
		bmapper.insert(board);

	}

	@Override
	public List<BoardDTO> list() {

		return bmapper.list();
	}

	@Override
	public BoardDTO view(int num) {
		return bmapper.view(num);
	}

	@Override
	public int delete(int num) {
		return bmapper.delete(num);

	}

	@Override
	public int count() {
		return bmapper.count();
	}

	@Override
	public void update(BoardDTO board) {
		bmapper.update(board);

	}

}
