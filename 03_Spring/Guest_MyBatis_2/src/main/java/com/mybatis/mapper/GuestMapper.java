package com.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mybatis.model.GuestVO;

public interface GuestMapper {

	// id �� :method�� �̸�
	// sql �� : annotation
	// parameter and result type : method�� ����
	@Insert("insert into guest(name,content, grade, created, ipaddr) values (#{name},#{content},#{grade}, now(), #{ipaddr})")
	public void insert(GuestVO guest);

	// annotaion�� ������� �ʰ� mapper.xml�� method�� ������ id�� ����ϸ� sql ��밡��
	// @Select("select * from guest")
	public List<GuestVO> list(HashMap<String, String> hm);

	// @Select("select count(*) from guest")
	public int count(HashMap<String, String> hm);

	@Select("select * from guest where num = #{num}")
	public GuestVO view(int num);

	@Delete("delete from guest where num = #{num}")
	public void delete(int num);
}
