package com.yjzs.gold.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取格式化好的当前时间
 *
 * @author Tght
 */
public class AppDateUtils {
    public static void main(String[] args) throws ParseException {
        // 当前时间
        Date dateTime = AppDateUtils.getDateTime();
        // 获取距当前的前一天时间
        Date date = AppDateUtils.DayToDay(dateTime, 1);
        // 将date转为字符串
        String s = AppDateUtils.DateDayToString(date);
        // 2022-09-12 20:04:46
        System.out.println(s);
    }

    /**
     *  算Date的时间差
     *
     * @param date1 date1
     * @param date2 date2
     * @return int
     */
    public static int DayNum(Date date1, Date date2) {
        return (int) ((date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
    }


    /**
     * 算出指定时间的前几天
     *
     * @param date 日期
     * @param day  一天
     * @return {@link Date}
     */
    public static Date DayToDay(Date date, int day) {
        return new Date(date.getTime() - (1000 * 3600 * 24) * day);
    }

    /**
     * 字符串转Date
     */
    public static Date StringToDate(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(time);
    }

    /**
     * Date转字符串    详细到秒
     */
    public static String DateDayToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * Date转字符串    详细到天
     */
    public static String DateDayToStringEasy(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 字符串转Date    详细到秒
     */
    public static Date StringToDateDay(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(time);
    }


    /**
     * 获取时间，Data类型
     */
    public static Date getDateTime() throws ParseException {
        //定义一个模板
        String str = "yyyy-MM-dd HH:mm:ss";
        //创建 SimpleDateFormat一个实例化对象
        SimpleDateFormat sd = new SimpleDateFormat(str);
        //解析字符串的文本，生成 Date
        Date d = sd.parse(getFormatTime());
        return new Timestamp(d.getTime());
    }


    /**
     * 获取当前时间
     * 精确到天数
     *
     * @return {@link String}
     */
    public static String getDayTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    /**
     * 获取当前时间
     * 精确到分钟
     *
     * @return {@link String}
     */
    public static String getFormatTimeHM() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date());
    }

    /**
     * 获取当前时间
     * 精确到秒
     *
     * @return {@link String}
     */
    public static String getFormatTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    /**
     * 自定义格式返回当前系统时间日期、时间字符串
     * yyyy-MM-dd HH:mm:ss
     */
    public static String getFormatTime(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }


    /**
     * 自定义指定时间的格式
     *
     * @param pattern 模式
     * @param date    日期
     * @return {@link String}
     */
    public static String getFormatTime(String pattern, Date date) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

}
