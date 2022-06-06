package com.chendb.sharding.utils;

import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.TreeSet;
import java.util.logging.SimpleFormatter;

/**
 * 日期工具类
 * @Author chendengbin
 * @Date 2022/6/5 23:45
 * @Version 1.0
 **/
public class DateUtils {

    /**
     * 获取年份
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return String.valueOf(year);
    }

    /**
     * 获取指定范围时间的年份范围
     * @param startDate
     * @param endDate
     * @return
     */
    public static TreeSet<String> getSuffixListForRange(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int startYear = calendar.get(Calendar.YEAR);

        calendar.setTime(endDate);
        int endYear = calendar.get(Calendar.YEAR);

        if (startYear < endYear) {
            return new TreeSet<>();
        }

        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = startYear; i <= endYear; i++) {
            treeSet.add(String.valueOf(i));
        }

        return treeSet;
    }

    /**
     * 将字符串转换成date
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date format(String dateStr, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
