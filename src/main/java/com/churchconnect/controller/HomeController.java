package com.churchconnect.controller;

import com.churchconnect.domain.member.MemberEntity;
import com.churchconnect.domain.member.MemberService;
import com.churchconnect.domain.member.dto.MemberSearchParam;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class HomeController {

    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public String home(Model model, @ModelAttribute("name") String name) {
        if (!name.isEmpty()) {
            MemberSearchParam param = new MemberSearchParam(name);
            List<MemberEntity> list = memberService.findBySearchParam(param);
            model.addAttribute("list", list);

            if (list.isEmpty()) {
                model.addAttribute("emptyList", true);
            }
        }

        return "home";
    }
}
