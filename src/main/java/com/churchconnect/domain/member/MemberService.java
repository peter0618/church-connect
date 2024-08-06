package com.churchconnect.domain.member;

import com.churchconnect.domain.member.dto.MemberSearchParam;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberEntity> findBySearchParam(MemberSearchParam param) {
        return memberRepository.findBySearchParam(param);
    }
}
