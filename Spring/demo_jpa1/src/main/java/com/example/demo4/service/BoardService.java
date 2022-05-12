package com.example.demo4.service;

import java.util.Date;

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

	@Transactional
	public Board view(Long num) {
		Board board = boardRepository.findById(num).get();
		board.setHitcount(board.getHitcount() + 1);
		return board;
	}

	@Transactional
	public void delete(Long num) {
//		boardRepository.deleteById(num);
		boardRepository.deleteByNum(num); // 쿼리 메서드 사용
	}

	@Transactional
	public void update(Board board) {
		Board context_board = boardRepository.findById(board.getNum()).get();
		context_board.setContent(board.getContent());
		context_board.setTitle(board.getTitle());
		context_board.setRegdate(new Date());

	}

}
