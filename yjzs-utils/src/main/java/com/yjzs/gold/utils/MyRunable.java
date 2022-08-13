package com.yjzs.gold.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import redis.clients.jedis.Jedis;

import java.util.*;


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

    public Jedis init(){
        Jedis jedis = new Jedis("106.14.164.228", 6379);
        jedis.auth("Ab123@wcj");
        return jedis;
    }


    @SneakyThrows
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            JSONObject jsonObject = null;
            for (int i = this.startId; i <= this.endId; i++) {
                jsonObject = FundUtils.getByFundCode_7Info(arr[i]);
                System.out.println(jsonObject.getString("name") + ":" + jsonObject.getString("gszzl") + "%");
                // 在这里将基金数据放入redis中，以list的方式
                // 一天的交易时间为9：30 - 11：30  and  13：00 - 15：00 共240分钟。也即是一个基金代码对应240条数据。
                // 第二日 9：30 之前删除。再重新创建list。（前提都是要满足交易日。）
                //存储 --- 当天日期：gsjz：code , jsonObject
                Jedis jedis = init();
                jedis.lpush(AppDateUtils.getDayTime()+":"+"gsjz"+":"+arr[i], jsonObject.toJSONString());
            }
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
