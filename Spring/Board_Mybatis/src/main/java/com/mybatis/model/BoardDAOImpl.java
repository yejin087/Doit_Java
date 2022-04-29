package com.mybatis.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.dto.BoardDTO;
import com.mybatis.dto.FileBoardDTO;
import com.mybatis.mapper.BoardMapper;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private BoardMapper mapper;

	@Override
	public void dao_insert(BoardDTO board) {
		mapper.insert(board);
	}

	@Override
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm) {

		return mapper.findAll(hm);
	}

	@Override
	public BoardDTO dao_findByNum(int num) {

		return mapper.findByNum(num);
	}

	@Override
	public void dao_update(BoardDTO board) {
		mapper.update(board);

	}

	@Override
	public void dao_delete(int num) {
		mapper.delete(num);

	}

	@Override
	public int dao_getCount(HashMap<String, Object> hm) {

		return mapper.getCount(hm);
	}

	@Override
	public void dao_fileInsert(FileBoardDTO fileboard) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FileBoardDTO> dao_fileList() {
		// TODO Auto-generated method stub
		return null;
	}

}
