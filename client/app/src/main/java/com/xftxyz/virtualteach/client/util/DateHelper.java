package com.xftxyz.virtualteach.client.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public static Date parse(String dateStr) {
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date) {
        return sdf.format(date);
    }
}
