package com.churchconnect.controller.member;

import com.churchconnect.common.util.PageUtil;
import com.churchconnect.controller.member.dto.MemberSearchParams;
import com.churchconnect.domain.member.MemberService;
import com.churchconnect.domain.member.dto.MemberPageDto;
import com.churchconnect.domain.member.dto.MemberSearchCriteria;
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
            pageListSize = 20; // fixme: 환경변수에서 default 받기
        }
        int blockListSize = 5; // fixme: 환경변수에서 default 받기

        MemberSearchCriteria criteria = MemberSearchCriteria.builder()
            .page(page)
            .pageListSize(pageListSize)
            .name(queryParams.getName())
            .build();

        MemberPageDto memberPageDto = memberService.findBySearchCriteria(criteria);
        PageUtil pageUtil = new PageUtil(page, memberPageDto.getTotalCount(), pageListSize, blockListSize);

        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("list", memberPageDto.getList());
        return "members/list";
    }
}
