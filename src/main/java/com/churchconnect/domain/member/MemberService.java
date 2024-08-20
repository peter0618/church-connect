package com.churchconnect.domain.member;

import com.churchconnect.domain.member.dto.MemberSearchCriteria;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberEntity> findBySearchCriteria(MemberSearchCriteria criteria) {
        return memberRepository.findBySearchCriteria(criteria);
    }
}
