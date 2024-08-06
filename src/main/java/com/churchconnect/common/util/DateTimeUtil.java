package com.churchconnect.common.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

    public static int calculateAge(Date birthDate, Calendar today) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        // 생일이 지나지 않았다면 나이를 1살 줄임
        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH) ||
            (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) &&
                today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age;
    }
}
