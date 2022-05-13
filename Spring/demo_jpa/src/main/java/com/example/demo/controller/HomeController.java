package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.JpaMember;
import com.example.demo.service.MemberService;

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("join")
    public String join() {
        return "join";
    }

    @PostMapping("join")
    public String join(JpaMember member) {
        memberService.save(member);
        return "redirect:list";
    }

    @GetMapping("list")
    public String list(Model model,
            @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        System.out.println("pageable : " + pageable);
        Page<JpaMember> lists = memberService.list(pageable);
        model.addAttribute("lists", lists);
        return "list";
    }

    // @GetMapping("list")
    // public String list(Model model) {
    // model.addAttribute("list", memberService.list());
    // return "list";
    // }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.findById(id));
        return "detail";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.findById(id));
        return "update";
    }

    @PutMapping("update")
    @ResponseBody
    public String update(@RequestBody JpaMember member) {
        System.out.println(member.getId());
        memberService.update(member);
        return "success";
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public Long delete(@PathVariable Long id) {
        memberService.delete(id);
        return id;
    }

}
