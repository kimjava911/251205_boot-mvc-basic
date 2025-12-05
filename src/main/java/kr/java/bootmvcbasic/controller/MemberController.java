package kr.java.bootmvcbasic.controller;

import kr.java.bootmvcbasic.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping // "/members"
    public String list(Model model) {
        model.addAttribute("members", memberRepository.findAll());
        return "members/list"; // WEB-INF/views/members/list.jsp
    }

    @GetMapping("/{id}") // @PathVariable Long id
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberRepository.findById(id).orElseThrow());
        return "members/detail";
    }
}
