package com.example.demo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo4.model.Board;
import com.example.demo4.model.Comment;
import com.example.demo4.repository.BoardRepository;
import com.example.demo4.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentrepository;

	@Autowired
	BoardRepository boardrepository;

	@Transactional
	public void insert(Comment comment) {
		// board replyCnt ++
		Long bnum = comment.getBoard().getNum();
		Board board = boardrepository.findById(bnum).get();
		board.setReplycnt(board.getReplycnt() + 1);

		// comment insert
		comment.setBoard(board);

		// commentrepository.save(comment);
		// 댓글 추가 JPQL 사용
		commentrepository.commentInsert(comment.getContent(), comment.getBoard().getNum(), comment.getUser().getId());
	}

	public List<Comment> list(Long bnum) {
//		Board board = boardrepository.findById(bnum).get();
		return commentrepository.findAllByBnum(bnum);
	}

	@Transactional
	public void delete(Long cnum) {
		Board board = commentrepository.findBordByCnum(cnum);
		// Board board = boardrepository.findById(bnum).get();
		board.setReplycnt(board.getReplycnt() - 1);
		commentrepository.deleteById(cnum);
	}
}
