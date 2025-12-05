package kr.java.bootmvcbasic.controller;

import kr.java.bootmvcbasic.model.form.MemberForm;
import kr.java.bootmvcbasic.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // 등록 폼 (GET)
    @GetMapping("/new")
    public String createForm() {
        return "members/form";
    }

    // 등록 처리 (POST)
    @PostMapping // POST /posts
    public String create(@ModelAttribute MemberForm form) {
        memberRepository.save(form.toEntity());
        return "redirect:/members";
    }
}
