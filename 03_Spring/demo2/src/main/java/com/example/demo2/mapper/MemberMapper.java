package com.example.demo2.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo2.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	public MemberDTO read(String username);
}
