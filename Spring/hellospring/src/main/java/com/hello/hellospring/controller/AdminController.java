package com.hello.hellospring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.hello.hellospring.model.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/*")
@Controller
public class AdminController {
    @Autowired
    MemberService memberService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("list")
    public String list(Model model) {
        List<Member> memberList = memberService.list();
        model.addAttribute("memberList", memberList);
        return "/member/list";
    }

    @DeleteMapping("delete/{username}")
    public ResponseEntity<String> delete(@PathVariable String username) {
        memberService.delete(username);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
