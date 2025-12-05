package kr.java.bootmvcbasic.controller;

import kr.java.bootmvcbasic.model.entity.Member;
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

    // 수정 폼 (GET)
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Member member = memberRepository.findById(id).orElseThrow();
        model.addAttribute("member", member);
        return "members/edit";
    }

    // 수정 처리 (POST)
    @PostMapping("/{id}") // POST /posts
    public String update(
            @PathVariable Long id,
            @ModelAttribute MemberForm form) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.setUsername(form.getUsername());
        member.setEmail(form.getEmail());
        memberRepository.save(member);;

        return "redirect:/members/{id}";
    }
}
