package com.churchconnect.controller.member;

import com.churchconnect.domain.member.MemberEntity;
import com.churchconnect.domain.member.MemberService;
import com.churchconnect.domain.member.dto.MemberSearchCriteria;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("members")
@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 목록을 조회합니다.
     */
    @GetMapping("")
    public String members(Model model){
        MemberSearchCriteria criteria = new MemberSearchCriteria(null); // TODO: 추후, 검색 기능 고도화 됨에 따라 수정 필요
        List<MemberEntity> list = memberService.findBySearchCriteria(criteria);

        model.addAttribute("list", list);
        return "members/list";
    }
}
