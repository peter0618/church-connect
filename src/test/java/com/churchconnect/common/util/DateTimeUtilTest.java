package com.churchconnect.common.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTimeUtilTest {

    @Test
    @DisplayName("나이는 생일이 지나면 'year 의 차이'로 계산됩니다.")
    void calculateAgeWhenBirthDayPassed() {
        //given
        // 생년월일 생성 (1985년 6월 18일)
        Calendar birthCal = Calendar.getInstance();
        birthCal.set(1985, Calendar.JUNE, 18);
        Date birthDate = birthCal.getTime();
        // 오늘 날짜 생성 (2024년 8월 17일)
        Calendar today = Calendar.getInstance();
        today.set(2024, Calendar.AUGUST, 17);

        System.out.println();

        //when
        int age = DateTimeUtil.calculateAge(birthDate, today);

        //then
        assertThat(age).isEqualTo(today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR));
    }

    @Test
    @DisplayName("나이는 생일이 지나지 않으면 'year 의 차이 - 1'로 계산됩니다.")
    void calculateAgeWhenBirthDayNotPassed() {
        //given
        // 생년월일 생성 (1985년 6월 18일)
        Calendar birthCal = Calendar.getInstance();
        birthCal.set(1985, Calendar.JUNE, 18);
        Date birthDate = birthCal.getTime();
        // 오늘 날짜 생성 (2024년 8월 17일)
        Calendar today = Calendar.getInstance();
        today.set(2024, Calendar.JANUARY, 1);

        //when
        int age = DateTimeUtil.calculateAge(birthDate, today);

        //then
        assertThat(age).isEqualTo(today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR) - 1);
    }
}