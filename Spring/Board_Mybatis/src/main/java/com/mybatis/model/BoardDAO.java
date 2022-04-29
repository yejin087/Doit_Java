package com.mybatis.model;

import java.util.HashMap;
import java.util.List;

import com.mybatis.dto.BoardDTO;
import com.mybatis.dto.FileBoardDTO;

public interface BoardDAO {
	// �߰�
	public void dao_insert(BoardDTO board);

	// ��ü ����
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm);

	// �� ����
	public BoardDTO dao_findByNum(int num);

	// ����
	public void dao_update(BoardDTO board);

	// ����
	public void dao_delete(int num);

	// ����
	public int dao_getCount(HashMap<String, Object> hm);

	// ���� �߰�
	public void dao_fileInsert(FileBoardDTO fileboard);

	// ���� ��ü ����
	public List<FileBoardDTO> dao_fileList();
}
