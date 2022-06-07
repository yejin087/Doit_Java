package com.react.reactspringjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.react.reactspringjpa.model.Board;
import com.react.reactspringjpa.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepositoy;

	public void insert(Board board) {
		boardRepositoy.save(board);
	}

	public List<Board> listAll() {
		return boardRepositoy.findAll();
	}

}
