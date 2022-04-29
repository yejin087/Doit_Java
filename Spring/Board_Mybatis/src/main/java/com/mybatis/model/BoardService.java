package com.mybatis.model;

import java.util.HashMap;
import java.util.List;

import com.mybatis.dto.BoardDTO;
import com.mybatis.dto.FileBoardDTO;

public interface BoardService {
	// 추가
	public void insert(BoardDTO board);

	// 전체 보기
	public List<BoardDTO> findAll(HashMap<String, Object> hm);

	// 상세 보기
	public BoardDTO findByNum(int num);

	public void update(BoardDTO board);

	public void delete(int num);

	public int getCount(HashMap<String, Object> hm);

	public void fileInsert(FileBoardDTO fileboard);

	public List<FileBoardDTO> fileList();

}
