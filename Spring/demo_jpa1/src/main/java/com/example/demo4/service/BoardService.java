package com.example.demo4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo4.model.Board;
import com.example.demo4.model.User;
import com.example.demo4.repository.BoardRepository;

@Transactional(readOnly = true) // 자동 flush 막는다
@Service
public class BoardService {
	@Autowired
	BoardRepository boardRepository;

	@Transactional
	public void insert(Board board, User user) {
		board.setUser(user);
		boardRepository.save(board);
	}

	public Page<Board> list(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	public Long count() {
		return boardRepository.count();
	}
}
