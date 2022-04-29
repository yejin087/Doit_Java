package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mybatis.dto.CommentDTO;

public interface CommentMapper {

	@Insert("insert into commentboard (content, bnum, userid) values(#{content}, #{bnum}, #{userid})")
	public void insert(CommentDTO comment);

	@Select("select * from commentboard where bnum=#{bnum}")
	public List<CommentDTO> getList(int bnum);

	@Delete("delete from commentboard where cnum = #{cnum}")
	public void delete(int cnum);
}
