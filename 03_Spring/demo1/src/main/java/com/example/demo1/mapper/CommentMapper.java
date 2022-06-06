package com.example.demo1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo1.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	@Insert("insert into commentboard (userid,content, bnum) values (#{userid},#{content}, #{bnum})")
	public void insert(CommentDTO comment);

	@Select("select * from commentboard where bnum=#{bnum}")
	public List<CommentDTO> list(int bnum);

	@Delete("delete from commentboard where cnum = #{cnum}")
	public int delete(int cnum);

	@Select("select * from commentboard where cnum=#{cnum}")
	public CommentDTO view(int cnum);
}
