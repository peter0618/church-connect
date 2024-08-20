package com.churchconnect.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("members")
@Controller
public class MemberController {

    /**
     * 회원 목록을 조회합니다.
     */
    @GetMapping("")
    public String members(Model model){
        return "members/list";
    }
}
