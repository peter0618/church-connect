package com.churchconnect.domain.member;

import com.churchconnect.domain.member.dto.MemberSearchParam;
import java.util.List;

public interface MemberRepository {
    List<MemberEntity> findBySearchParam(MemberSearchParam param);
}
