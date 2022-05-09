package com.example.demo1.service;

import java.util.List;

import com.example.demo1.dto.BoardDTO;

public interface BoardService {

	public void insert(BoardDTO board);

	public List<BoardDTO> list();

	public BoardDTO view(int num);

	public int delete(int num);

	public int count();

	public void update(BoardDTO board);
}
