package com.yjzs.gold.main.service.impl;

import com.yjzs.gold.utils.AppDateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ScheduledServiceImpl {

    /**
     * 在一个特定的一个时间执行这个方法 Timer
     * cron表达式
     *  秒 分 时 日 月 周几
     * (cron = “0 29 10 * * ?”)
     *
     * 0 49 11 * * ?   每天的11点49分00秒执行
     *         0 0/5 11,12 * * ?   每天的11点和12点每个五分钟执行一次
     *         0 15 10 ? * 1-6     每个月的周一到周六的10点15分执行一次
     *         0/2 * * * * ?     每2秒执行一次
     *  "40 55 15 * * ?" 这是下午3点 55分 40秒的样子
     */
    @Scheduled(cron = "00 30 9 * * ?")
    public void hello() throws ParseException {
        System.out.println("hello,被执行了张"+ AppDateUtils.getDateTime());
    }
}
