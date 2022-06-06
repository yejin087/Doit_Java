package com.myspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.myspring.dto.CommentDTO;

public interface CommentMapper {

	@Insert("insert into commentboard (userid, content, bnum) values (#{userid}, #{content}, #{bnum})")
	public void insert(CommentDTO comment);

	@Select("select * from commentboard where bnum = #{bnum}")
	public List<CommentDTO> list(int bnum);

	@Delete("delete from commentboard where cnum = #{cnum}")
	public int delete(int cnum);
}
