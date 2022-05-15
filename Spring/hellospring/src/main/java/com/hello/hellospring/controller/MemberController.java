package com.hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.hellospring.model.Member;
import com.hello.hellospring.model.PrincipalDetails;
import com.hello.hellospring.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("join")
    public String join() {
        return "/member/join";
    }

    @PostMapping("join")
    public void join(@RequestBody Member member) {
        memberService.join(member);
    }

    @GetMapping("login")
    public String login() {
        return "/member/login";
    }

    @GetMapping("fail")
    public String fail(Model model) {
        model.addAttribute("errorMsg", "로그인 실패");
        return "/member/login";
    }

    @GetMapping("update")
    public String update(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
        Member member = memberService.view(principal.getUsername());
        model.addAttribute("member", member);
        return "/member/update";
    }

    @PutMapping("update")
    public ResponseEntity<String> update(@RequestBody Member member) {
        memberService.update(member);
        /* 변경된 세션 등록 */
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("success", HttpStatus.OK);

    }

    @DeleteMapping("delete")
    public ResponseEntity<String> delete(String username) {
        memberService.delete(username);
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
