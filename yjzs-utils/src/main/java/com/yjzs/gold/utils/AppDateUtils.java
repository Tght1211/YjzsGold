package com.yjzs.gold.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取格式化好的当前时间
 * @author Tght
 */
public class AppDateUtils {


    public static int DayNum(Date date1 ,Date date2){
        // 算时间差
        int days = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
        return days;
    }


    /**
     * 字符串转Date
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(time);
        return date;
    }
    /**
     * Date转字符串    详细到天
     *
     * @return
     * @throws ParseException
     */
    public static String DateDayToString(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(date);
        return s;
    }
    /**
     * 字符串转Date    详细到天
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date StringToDateDay(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(time);
        return date;
    }


    /**
     * 获取时间，Data类型
     * @return
     * @throws ParseException
     */
    public static Date getDateTime() throws ParseException {
        //定义一个模板
        String str = "yyyy-MM-dd HH:mm:ss";
        //创建 SimpleDateFormat一个实例化对象
        SimpleDateFormat sd = new SimpleDateFormat(str);
        //解析字符串的文本，生成 Date
        Date d = sd.parse(getFormatTime());
        Timestamp timestamp = new Timestamp(d.getTime());
        return timestamp;
    }


    public static String getDayTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String string = format.format(new Date());
        return string;
    }



    public static String getFormatTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = format.format(new Date());
        return string;
    }

    /**
     * 根据日志格式返回当前系统时间日期、时间字符串
     * @param  ：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getFormatTime(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String string = format.format(new Date());
        return string;
    }



    public static String getFormatTime(String pattern, Date date) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String string = format.format(date);
        return string;
    }

}
