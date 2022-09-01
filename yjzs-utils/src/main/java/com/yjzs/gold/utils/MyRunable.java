package com.yjzs.gold.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import redis.clients.jedis.Jedis;

import java.text.ParseException;
import java.util.*;

import static com.yjzs.gold.utils.AppDateUtils.StringToDate;


/**
 * @author Tght
 * 一分钟一次的线程获取
 */
public class MyRunable implements Runnable {


    private int startId;
    private int endId;
    private String[] arr;

    public MyRunable(int startId, int endId, String[] arr) {
        this.startId = startId;
        this.endId = endId;
        this.arr = arr;
    }

    public static Jedis init() {
        Jedis jedis = new Jedis("180.76.181.56", 6379);
        jedis.auth("Ab123@wcj");
        return jedis;
    }


    public void run() {
        JSONObject jsonObject;
        for (int i = this.startId; i < Math.min(this.endId, arr.length); i++) {
            try {
                jsonObject = FundUtils.getByFundCode_7Info(arr[i]);
            } catch (Exception e) {
                System.out.println("----------------------获取基金接口信息异常----------------------");
                throw new RuntimeException(e);
            }
            System.out.println(arr[i] + ":" + jsonObject.getString("name") + ":" + jsonObject.getString("gszzl") + "%");
            Jedis jedis = init();
            //前一天的 "2022-08-26 15:00";
            String dayTime = AppDateUtils.getDayTime();
            Date date;
            try {
                date = StringToDate(dayTime);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            // 昨天
            Date yesDate = new Date(date.getTime() - (1000 * 3600 * 24));
            String sData = AppDateUtils.DateDayToStringEasy(yesDate);
            sData = sData + " 15:00";
            if (!jsonObject.get("gztime").equals(sData)) {
                // 在这里将基金数据放入redis中，以list的方式
                // 一天的交易时间为9：30 - 11：30  and  13：00 - 15：00 共240分钟。也即是一个基金代码对应240条数据。
                // 第二日 9：30 之前删除。再重新创建list。（前提都是要满足交易日。）
                //存储 --- 当天日期：gsjz：code , jsonObject

                String headKey = AppDateUtils.getDayTime() + ":" + "gsjz" + ":" + arr[i];
                String tailValue = jsonObject.toJSONString();
                System.out.println(headKey + "----------------------------------------" + tailValue);
//                jedis.lpush(AppDateUtils.getDayTime()+":"+"gsjz"+":"+arr[i], jsonObject.toJSONString());
                jedis.lpush(headKey, tailValue);
            } else {

                // 15次机会，还不更新的，判定为休休息日
                if (jedis.llen(AppDateUtils.getDayTime() + ":" + "errorFund" + ":" + arr[i]) >= 15) {
                    break;
                }
                jedis.lpush(AppDateUtils.getDayTime() + ":" + "errorFund" + ":" + arr[i], "未更新:" + jsonObject.toJSONString());
            }
        }
    }
}
