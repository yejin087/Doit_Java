package com.hello.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
        return memberRepository.findById(username).get();
    }

    @Transactional
    public void update(Member member) {
        Member context_member = memberRepository.findById(member.getUsername()).get();

        String rawPassword = member.getPassword();
        String encPassword = bcryptPasswordEncoder.encode(rawPassword);

        context_member.setPassword(encPassword);
        context_member.setEmail(member.getEmail());
    }

    public void delete(String username) {
        memberRepository.deleteById(username);
    }

    public List<Member> list() {
        return memberRepository.findAll();
    }
}
