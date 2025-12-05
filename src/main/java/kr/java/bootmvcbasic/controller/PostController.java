package kr.java.bootmvcbasic.controller;

import kr.java.bootmvcbasic.model.entity.Member;
import kr.java.bootmvcbasic.model.entity.Post;
import kr.java.bootmvcbasic.model.form.MemberForm;
import kr.java.bootmvcbasic.model.form.PostForm;
import kr.java.bootmvcbasic.model.repository.MemberRepository;
import kr.java.bootmvcbasic.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor // <- 생성자 주입 (final)
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    // 목록 조회
    @GetMapping // GET /posts
    public String list(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts/list";
    }

    // 게시물 작성
    @GetMapping("/new") // GET /posts/new
    public String createForm(Model model) {
        // 작성자 선택을 위한 회원 목록
        model.addAttribute("members", memberRepository.findAll());
        return "posts/form";
    }

    // 작성 처리
    @PostMapping
    public String create(@ModelAttribute PostForm form) {
        Member member = memberRepository.findById(form.getMemberId())
                .orElseThrow();
        postRepository.save(form.toEntity(member));
//        return "redirect:/posts";
        return "redirect:/posts/" + form.getMemberId();
    }

    // 개별 보기
    @GetMapping("/{id}") // @PathVariable Long id
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("post", postRepository.findById(id).orElseThrow());
        return "posts/detail";
    }

    // 수정 폼
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        model.addAttribute("post", post);
        return "posts/edit";
    }

    // 수정 처리
    @PostMapping("/{id}") // POST /posts
    public String update(
            @PathVariable Long id,
            @ModelAttribute PostForm form) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        postRepository.save(post);
        return "redirect:/posts/{id}";
    }

    // 삭제
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/posts";
    }
}
