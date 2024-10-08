package com.churchconnect.controller.member;

import com.churchconnect.common.util.PageUtil;
import com.churchconnect.controller.member.dto.MemberSearchParams;
import com.churchconnect.domain.member.MemberEntity;
import com.churchconnect.domain.member.MemberExcelFile;
import com.churchconnect.domain.member.MemberService;
import com.churchconnect.domain.member.dto.MemberPageDto;
import com.churchconnect.domain.member.dto.MemberSearchCriteria;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
            .cellName(queryParams.getCellName())
            .build();

        MemberPageDto memberPageDto = memberService.findBySearchCriteria(criteria);
        PageUtil pageUtil = new PageUtil(page, memberPageDto.getTotalCount(), pageListSize, blockListSize);

        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("list", memberPageDto.getList());
        return "members/list";
    }

    @GetMapping(value = "/excel/downloadAll")
    public void excelDownloadAll(HttpServletResponse response) throws IOException {
        List<MemberEntity> list = memberService.findAll();

        MemberExcelFile memberExcelFile = new MemberExcelFile(list);

        // 컨텐츠 타입과 파일명 지정
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=members.xlsx");

        // Excel File Output
        memberExcelFile.write(response.getOutputStream());
    }

    @GetMapping(value = "/excel/download")
    public void excelDownload(@ModelAttribute MemberSearchParams queryParams, HttpServletResponse response) throws IOException {
        int page = queryParams.getPage();
        int pageListSize = queryParams.getPageListSize();
        if (page < 1) {
            page = 1; // fixme: 환경변수에서 default 받기
        }
        if (pageListSize < 1) {
            pageListSize = 20; // fixme: 환경변수에서 default 받기
        }

        MemberSearchCriteria criteria = MemberSearchCriteria.builder()
            .page(page)
            .pageListSize(pageListSize)
            .name(queryParams.getName())
            .cellName(queryParams.getCellName())
            .build();

        MemberPageDto memberPageDto = memberService.findBySearchCriteria(criteria);
        List<MemberEntity> list = memberPageDto.getList();

        MemberExcelFile memberExcelFile = new MemberExcelFile(list);

        // 컨텐츠 타입과 파일명 지정
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=members.xlsx");

        // Excel File Output
        memberExcelFile.write(response.getOutputStream());
    }
}
