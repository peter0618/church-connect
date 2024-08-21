package com.churchconnect.repository.member;

import com.churchconnect.domain.member.MemberEntity;
import com.churchconnect.domain.member.dto.MemberSearchCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyBatisMemberMapper {
    List<MemberEntity> findBySearchCriteria(MemberSearchCriteria criteria);
    int totalCountByCriteria(MemberSearchCriteria criteria);
    List<MemberEntity> findAll();
}
