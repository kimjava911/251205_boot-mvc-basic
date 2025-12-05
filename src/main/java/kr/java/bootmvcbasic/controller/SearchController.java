package kr.java.bootmvcbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchController {
    @GetMapping
//    public String search(@RequestParam(name = "keyword") String keyword) {
    public String search(
            @RequestParam String keyword,
            Model model) {
        // annotation processor 활성화 시 들어오는 속성과 메서드 패러미터가 같다면 생략 가능
        model.addAttribute("keyword", keyword);
        model.addAttribute("message", keyword + "에 대한 검색 결과");
        return "search/result";
    }

    @GetMapping("/posts")
    public String searchPosts(
            @RequestParam(required = false) String keyword, // 없어도 400 에러를 내지 않음
            @RequestParam(defaultValue = "1") int page, // 기본값 1
            @RequestParam(defaultValue = "10") int size, // 기본값 10
            Model model) {

        model.addAttribute("keyword", keyword); // keyword가 null일 수 있음
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "search/posts";
    }


}
