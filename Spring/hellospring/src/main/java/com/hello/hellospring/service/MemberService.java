package com.hello.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hello.hellospring.model.Member;
import com.hello.hellospring.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	public void join(@RequestBody Member member) {

		String rawPassword = member.getPassword();
		String encPassword = bcryptPasswordEncoder.encode(rawPassword);
		member.setPassword(encPassword);

		memberRepository.save(member);
	}

	public Member view(String username) {
		return memberRepository.findByUsername(username);
	}
}
