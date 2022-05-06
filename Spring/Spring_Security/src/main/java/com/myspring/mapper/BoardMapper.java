package com.myspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.myspring.dto.BoardDTO;

public interface BoardMapper {
	public void insert(BoardDTO board);

	public List<BoardDTO> list();

	public int count();

	@Select("select * from board where num=#{num}")
	public BoardDTO view(int num);

	public void updateReplyCnt(@Param("bnum") int bnum, @Param("amount") int amount);
}
