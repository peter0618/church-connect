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
        MALE("남"),
        FEMALE("여");

        private final String koreanName;

        // 생성자
        Gender(String koreanName) {
            this.koreanName = koreanName;
        }

        // 한글명을 반환하는 메서드
        public String getKoreanName() {
            return koreanName;
        }

        // 한글명으로 Gender를 찾는 정적 메서드
        public static Gender fromKoreanName(String koreanName) {
            for (Gender gender : Gender.values()) {
                if (gender.koreanName.equals(koreanName)) {
                    return gender;
                }
            }
            throw new IllegalArgumentException("Unknown Korean name: " + koreanName);
        }
    }

    /**
     * 현재 시각을 기준으로 나이를 계산하여 반환합니다.
     */
    public int age() {
        return DateTimeUtil.calculateAge(birthDate, Calendar.getInstance());
    }
}