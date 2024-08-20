package com.churchconnect.repository.member;

import com.churchconnect.domain.member.MemberEntity;
import com.churchconnect.domain.member.MemberRepository;
import com.churchconnect.domain.member.dto.MemberSearchCriteria;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisMemberRepository implements MemberRepository {

    private final MyBatisMemberMapper mapper;

    public MyBatisMemberRepository(MyBatisMemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MemberEntity> findBySearchCriteria(MemberSearchCriteria criteria) {
        return mapper.findBySearchCriteria(criteria);
    }
}
