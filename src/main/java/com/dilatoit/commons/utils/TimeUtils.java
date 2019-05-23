package com.dilatoit.commons.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
public class TimeUtils {

    /**
     * millis convert to Date
     * @param millis
     * @return
     */
    public static Date convertMillisToDate(long millis){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
