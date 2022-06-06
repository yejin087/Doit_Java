package com.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.dto.BoardDTO;
import com.mybatis.dto.FileBoardDTO;

public interface BoardMapper {

	// �߰�
	@Insert("insert into board (title, writer, content) values (#{title}, #{writer}, #{content})")
	public void insert(BoardDTO board);

	// ��ü ����
	// @Select("select * from board")
	public List<BoardDTO> findAll(HashMap<String, Object> hm);

	// �� ����
	@Select("select * from board where num = #{num}")
	public BoardDTO findByNum(int num);

	@Update("update board set title=#{title}, content =#{content}, regdate=now() where num = #{num}")
	public void update(BoardDTO board);

	@Delete("delete from board where num = #{num}")
	public void delete(int num);

	// @Select("select count(*) from board")
	public int getCount(HashMap<String, Object> hm);

	public void fileInsert(FileBoardDTO fileboard);

	public List<FileBoardDTO> fileList();

}
