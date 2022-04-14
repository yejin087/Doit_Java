package com.member.dao;

import java.util.ArrayList;

import com.member.dto.MemberDTO;

public interface MemberDAO {

	// 추가
	public void memberInsert(MemberDTO dto);

	// 전체 보기
	public ArrayList<MemberDTO> memberList();

	// 수정
	public void memeberUpdate(MemberDTO dto);

	// 삭제
	public void memeberDelete(String userid);

	// 상세 보기
	public MemberDTO findById(String userid);

	// 아이디 중복 체크
	public String idCheck(String userid);

	// 로그인 체크
	public int loginCheck(String userid, String pwd);

	// 회원수
	public int getcount();
}
