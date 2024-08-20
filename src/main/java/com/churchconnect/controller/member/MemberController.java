package com.churchconnect.controller.member;

import com.churchconnect.controller.member.dto.MemberSearchParams;
import com.churchconnect.domain.member.MemberEntity;
import com.churchconnect.domain.member.MemberService;
import com.churchconnect.domain.member.dto.MemberSearchCriteria;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String members(Model model, @ModelAttribute MemberSearchParams queryParams){
        int page = queryParams.getPage();
        int pageListSize = queryParams.getPageListSize();
        if (page < 1) {
            page = 1; // fixme: 환경변수에서 default 받기
        }
        if (pageListSize < 1) {
            pageListSize = 10; // fixme: 환경변수에서 default 받기
        }
        int blockListSize = 5; // fixme: 환경변수에서 default 받기

        MemberSearchCriteria criteria = MemberSearchCriteria.builder()
            .page(page)
            .pageListSize(pageListSize)
            .name(queryParams.getName())
            .build();

        List<MemberEntity> list = memberService.findBySearchCriteria(criteria);

        model.addAttribute("list", list);
        return "members/list";
    }
}
