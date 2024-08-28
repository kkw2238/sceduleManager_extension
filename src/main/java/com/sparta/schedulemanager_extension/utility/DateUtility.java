package com.sparta.schedulemanager_extension.utility;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateUtility {
    static String PARSE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    static String ZONE_ID = "Asia/Seoul";

    public static String localDateTimeToString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(PARSE_FORMAT));
    }

    public static ZoneId getTimeZone() {
        return ZoneId.of(ZONE_ID);
    }
}
