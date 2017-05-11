package com.py.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by pysasuke on 16/8/11.
 *
 * 时间工具类
 */
public class TimeTools {

    /**
     * 日期时间戳生成
     *
     * @return "2017-05-09"格式
     */
    public static String getCodingDate() {
        String date = null;
        Calendar calendar = new GregorianCalendar();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);
        String day_of_month = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        date = year + month + day_of_month;
        return date;
    }

}
