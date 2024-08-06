package com.churchconnect.repository.member;

import com.churchconnect.domain.member.MemberEntity;
import com.churchconnect.domain.member.dto.MemberSearchParam;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyBatisMemberMapper {
    List<MemberEntity> findBySearchParam(MemberSearchParam param);
}
