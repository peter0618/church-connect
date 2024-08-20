package com.churchconnect.domain.member;

import com.churchconnect.domain.member.dto.MemberSearchCriteria;
import java.util.List;

public interface MemberRepository {
    List<MemberEntity> findBySearchCriteria(MemberSearchCriteria criteria);
}
