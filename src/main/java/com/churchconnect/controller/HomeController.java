package com.churchconnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("message", "테스트 home 입니다.");
        return "home";
    }
}
