package com.hello.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.hellospring.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	public Member findByUsername(String username);
}
