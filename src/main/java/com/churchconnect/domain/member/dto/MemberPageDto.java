package com.churchconnect.domain.member.dto;

import com.churchconnect.domain.member.MemberEntity;
import java.util.List;
import lombok.Getter;

@Getter
public class MemberPageDto {
    private final List<MemberEntity> list;
    private final int totalCount;

    public MemberPageDto(List<MemberEntity> list, int totalCount) {
        this.list = list;
        this.totalCount = totalCount;
    }
}
