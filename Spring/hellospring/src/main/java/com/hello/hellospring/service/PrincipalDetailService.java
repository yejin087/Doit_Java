package com.hello.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hello.hellospring.model.Member;
import com.hello.hellospring.model.PrincipalDetails;
import com.hello.hellospring.repository.MemberRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("load user by username");
		Member member = memberRepository.findByUsername(username);

		if (member == null)
			return null;

		PrincipalDetails puser = new PrincipalDetails(member);

		return puser;
	}

}
