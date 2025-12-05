package kr.java.bootmvcbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/filter")
public class FilterController {

    @GetMapping // /filter
    public String filter(
            @RequestParam(required = false) List<String> tags, // 여러개를 List 받음
            Model model) {
        model.addAttribute("tags", tags); // null or []
        return "filter/result";
    }
}
