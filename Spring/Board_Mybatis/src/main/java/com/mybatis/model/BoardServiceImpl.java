package com.mybatis.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dto.BoardDTO;
import com.mybatis.dto.FileBoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;

	@Override
	public void insert(BoardDTO board) {
		dao.dao_insert(board);
	}

	@Override
	public List<BoardDTO> findAll(HashMap<String, Object> hm) {

		return dao.dao_findAll(hm);
	}

	@Override
	public BoardDTO findByNum(int num) {

		return dao.dao_findByNum(num);
	}

	@Override
	public void update(BoardDTO board) {

		dao.dao_update(board);

	}

	@Override
	public void delete(int num) {
		dao.dao_delete(num);
	}

	@Override
	public int getCount(HashMap<String, Object> hm) {

		return dao.dao_getCount(hm);
	}

	@Override
	public void fileInsert(FileBoardDTO fileboard) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FileBoardDTO> fileList() {
		// TODO Auto-generated method stub
		return null;
	}

}
