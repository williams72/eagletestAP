package com.dilatoit.eagletest.util;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by xueshan.wei on 3/23/2017.
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{
    private static String[] parsePatterns = {
            "yyyyMMdd", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    public static Date fromStringToDate(String dateStr) {
        if(dateStr == null){
            return null;
        }
        try {
            return parseDate(dateStr, parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
