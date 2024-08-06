package com.churchconnect.domain.member;

import com.churchconnect.common.domain.BaseEntity;
import com.churchconnect.common.util.DateTimeUtil;
import java.util.Calendar;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
public class MemberEntity extends BaseEntity {
    private Long id; // Primary Key
    private String name;
    private Date birthDate;
    private String phoneNumber;
    private Date registrationDate;
    private String position; // 직분
    private String cellName; // 셀이름
    private String address;
    private String familyInfo; // 가족 정보
    private String note; // 비고
    private Gender gender; // 성별

    public enum Gender {
        MALE,
        FEMALE
    }

    /**
     * 현재 시각을 기준으로 나이를 계산하여 반환합니다.
     */
    public int age() {
        return DateTimeUtil.calculateAge(birthDate, Calendar.getInstance());
    }
}