package com.sparta.schedulemanager_extension.utility;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 *  날짜 / 시간과 관련된 유틸리티
 */
public class DateUtility {
    static String PARSE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    static String ZONE_NAME = "Asia/Seoul";

    /**
     * @param date 문자열로 변환하고자 하는 LocalDateTime 객체
     * @return date를 Format에 맞춰 변환한 문자열
     */
    public static String localDateTimeToString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(PARSE_FORMAT));
    }

    /**
     * @return Asia/Seoul의 zoneId
     */
    public static ZoneId getTimeZone() {
        return ZoneId.of(ZONE_NAME);
    }
}
