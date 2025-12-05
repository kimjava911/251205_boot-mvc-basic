package kr.java.bootmvcbasic.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RequestMapping("/")
public class HomeController {

//    @RequestMapping
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    // 모든 접근 요청에 대해서, "/"의 경로에 대해 연결.
//    public String home(Model model, HttpServletRequest request) {
//    public String home(Model model) {
//    public ModelAndView home(Model model) {
    public String home(Model model) {
//        if (request.getMethod().equals("GET")) {}
//        if (request.getMethod().equals("POST")) {}
        model.addAttribute("message", "Welcome Spring MVC!");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index");
//        return mv;
        return "index"; // view name -> prefix + name + suffix -> view
    }
}
