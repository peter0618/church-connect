package com.churchconnect.domain.member;

import com.churchconnect.domain.member.dto.MemberPageDto;
import com.churchconnect.domain.member.dto.MemberSearchCriteria;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberPageDto findBySearchCriteria(MemberSearchCriteria criteria) {
        List<MemberEntity> list = memberRepository.findBySearchCriteria(criteria);
        int totalCount = memberRepository.totalCountByCriteria(criteria);
        return new MemberPageDto(list, totalCount);
    }

    public List<MemberEntity> findAll() {
        return this.memberRepository.findAll();
    }
}
