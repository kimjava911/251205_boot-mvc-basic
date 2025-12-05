package kr.java.bootmvcbasic.controller;

import jakarta.servlet.http.HttpSession;
import kr.java.bootmvcbasic.model.entity.Member;
import kr.java.bootmvcbasic.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {
    private final MemberRepository memberRepository;

    // 로그인 폼
    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        HttpSession session) {
        Member member = memberRepository.findByUsername(username).orElseThrow();
        session.setAttribute("loginMember", member);
        // 유효시간 설정
        session.setMaxInactiveInterval(1800); // 30분 = 30 * 60 초 = 1800초
        return "redirect:/";
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginMember"); // 해당 속성만 제거
//        session.invalidate(); // 아예 세션을 무효화
        return "redirect:/";
    }

    // 로그인 프로필
    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        Member loginMember = (Member) session.getAttribute("loginMember");
        if (loginMember == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("member", loginMember);
        return "auth/profile";
    }
}
