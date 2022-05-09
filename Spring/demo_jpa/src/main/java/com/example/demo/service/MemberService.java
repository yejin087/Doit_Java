package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.JpaMember;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 멤버 변수를 가지는 생성자를 만들어준다
public class MemberService {

	private final MemberRepository memberRepository;

	public void save(JpaMember member) {
		memberRepository.save(member);
	}

	public List<JpaMember> list() {
		return memberRepository.findAll();
	}
}
