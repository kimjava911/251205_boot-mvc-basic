package kr.java.bootmvcbasic.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cookie")
public class CookieController {
    // 쿠키를 저장
    @GetMapping("/set")
    public String setCookie(
            @RequestParam String theme,
            HttpServletResponse response
    ) {
        Cookie cookie = new Cookie("userTheme", theme);

        cookie.setMaxAge(60 * 60 * 24 * 7); // 7일 유효
        cookie.setPath("/"); // -> 디폴트는 전달받은 URL. 의도적으로 풀면 "/". 같은 도메인에서 접근 가능.
        response.addCookie(cookie);
        return "redirect:/cookie/view";
    }

    // 쿠키 읽기
    @GetMapping("/view")
    public String viewCookie(
//            HttpServletRequest request
            @CookieValue(name = "userTheme", defaultValue = "light")
            String theme,
            Model model
    ) {
//        request.getCookies()
        model.addAttribute("theme", theme);
        return "cookie/view";
    }

    // 쿠키 삭제
    @GetMapping("/delete")
    public String deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("userTheme", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/cookie/view";
    }
}
