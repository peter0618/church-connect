package com.churchconnect.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class MemberSearchCriteria {
    int page;
    int pageListSize;
    String name;
    String cellName;
}
