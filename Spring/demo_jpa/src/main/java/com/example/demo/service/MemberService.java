package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.JpaMember;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 멤버 변수를 가지는 생성자를 만들어준다
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void save(JpaMember member) {
        memberRepository.save(member);
    }

    // public List<JpaMember> list() {
    // return memberRepository.findAll();
    // }

    public Page<JpaMember> list(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    public JpaMember findById(Long id) {
        return memberRepository.findById(id).get();
    }

    public void getById(Long id) {
        memberRepository.getById(id);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public void update(JpaMember member) {
        // 바뀌기 전 내용
        JpaMember jpamember = memberRepository.findById(member.getId()).get();

        // 바뀐 내용 set
        jpamember.setName(member.getName());
        jpamember.setPassword(member.getPassword());
        jpamember.setAddr(member.getAddr());
        jpamember.setEmail(member.getEmail());
        jpamember.setMemo(member.getMemo());

    }

}
