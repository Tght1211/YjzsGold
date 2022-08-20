package com.yjzs.gold.main.common;

import com.yjzs.gold.main.bean.TFund;
import com.yjzs.gold.main.service.TFundService;
import com.yjzs.gold.utils.FundTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO:实现定时任务实际效果
 * //1.主要用于标记配置类，兼备Component的效果。
 *      * 样例 （仅供参考，部分可能不对）
 *      * 5 0 0 * * ? 每天晚上12:00:05点开始同步数据  秒 分 时
 *      * 0 0/30 9-17 * * ? 早晨9点到下午5点，每半小时执行一次
 *      * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
 *      * 0 0 12 ? * WED 表示每个星期三中午12点
 *      * 0 0 12 * * ? 每天中午12点触发
 *      * 0 15 10 ? * * 每天上午10:15触发
 *      * 0 15 10 * * ? 每天上午10:15触发
 *      * 0 15 10 * * ? * 每天上午10:15触发
 *      * 0 15 10 * * ? 2005 2005年的每天上午10:15触发
 *      * 0 * 14 * * ? 在每天下午2点到下午2:59期间的每1分钟触发
 *      * 0 0/5 14 * * ? 在每天下午2点到下午2:55期间的每5分钟触发
 *      * 0 0/5 14,18 * * ? 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 *      * 0 0-5 14 * * ? 在每天下午2点到下午2:05期间的每1分钟触发
 *      * 0 10,44 14 ? 3 WED 每年三月的星期三的下午2:10和2:44触发
 *      * 0 15 10 ? * MON-FRI 周一至周五的上午10:15触发
 *      * 0 15 10 15 * ? 每月15日上午10:15触发
 *      * 0 15 10 L * ? 每月最后一日的上午10:15触发
 *      * 0 15 10 ? * 6L 每月的最后一个星期五上午10:15触发
 *      * 0 15 10 ? * 6L 2002-2005 2002年至2005年的每月的最后一个星期五上午10:15触发
 *      * 0 15 10 ? * 6#3 每月的第三个星期五上午10:15触发
 *
 *
 *
 *
 *
 *           * 定时获取基金数据
 *      * ①每日的 9.30-11.30   13:00-15:00
 *      *
 *      * ②判断是否数据1-条都重复，重复就停止获取，并删除{
 *      *     获取第一条基代码的list，查大小>10，再判断数据是否一致，一致就直接退出，不再计算。
 *      * }
 *      *
 *      * ③写一个公共获取基金的方法。{
 *      *     Ⅰ.根据基金仓库的数据来决定开几个线程。（争取一分钟内跑完这个数据存储的过程）
 *      *     Ⅱ.获取数据后，将数据放入redis的list中。根据基金代码为标识
 *      * }
 *      *
 *      * 0 30/1 9-11 * * ?  每日早上9点30到11点30，每隔1分钟请求一次 （要实现每一分钟请求一次，而不是请求完了隔一分钟）
 */
@Configuration
public class TimedTask {


    @Autowired
    TFundService tFundService;


/*    @Scheduled(cron = "0 0-59 1 * * ?")
    private void scheduledTest() throws Exception {
        // test 1点的0分到59分钟，每分钟执行一次
        System.err.println("测试执行定时: " + LocalDateTime.now()+"----test cron = \"0 0-59 1 * * ?\"");
        getFundToRedis();
    }*/

    /**
     * 获取数据库中存入的基金代码数据
     */
    public void getFundToRedis() {
        List<TFund> list = tFundService.list();
//        List<String> codeList = list.stream().map(TFund::getFundCode).collect(Collectors.toList());
        String[] codeArr = list.stream().map(TFund::getFundCode).toArray(String[]::new);
        int size = codeArr.length;
        int x;
        // 1.开启线程获取每个基金的数据，并存入redis，定义线程的多少
        if (size <= 50) {
            x = 2;
        } else if (50 < size && size <= 100) {
            x = 4;
        } else if (100 < size && size <= 500) {
            x = 6;
        } else if (500 < size && size < 1000) {
            x = 8;
        } else {
            x = 10;
        }
        // 基金代码数组、开启线程个数
        FundTime.getFund(codeArr, x);
    }


    /**
     * A.早上 9:30-9:59
     */
    @Scheduled(cron = "0 30-59 9 * * ?")
    private void scheduledMorningA() {

        System.err.println("执行静态定时任务时间-----开始同步数据到Redis-----: " + LocalDateTime.now() + "----早上 9:30-9:59");
        getFundToRedis();
    }

    /**
     * B.早上核心时间 10:00 - 10:59
     */
    @Scheduled(cron = "0 0-59 10 * * ?")
    private void scheduledMorningB() {

        System.err.println("执行静态定时任务时间-----开始同步数据到Redis-----: " + LocalDateTime.now() + "----早上核心时间 10:00 - 10:59");
        getFundToRedis();
    }

    /**
     * C.早上 11:00-11:30
     */
    @Scheduled(cron = "0 0-30 11 * * ?")
    private void scheduledMorningC() {

        System.err.println("执行静态定时任务时间-----开始同步数据到Redis-----: " + LocalDateTime.now() + "----早上 11:00-11:30");
        getFundToRedis();
    }


    /**
     * 0 0-59 13-14 * * ?  下午13点到14点，每一分钟请求一次
     */
    @Scheduled(cron = "0 0-59 13-14 * * ?")
    private void scheduledAfternoonA() {

        System.err.println("执行静态定时任务时间-----开始同步数据到Redis-----: " + LocalDateTime.now() + "----下午 13:00-14:59");
        getFundToRedis();
    }

    /**
     * 0 0 15 * * ?  每日下午15:00，请求一次
     */
    @Scheduled(cron = "0 0 15 * * ?")
    private void scheduledAfternoonB() {

        System.err.println("执行静态定时任务时间-----开始同步数据到Redis-----: " + LocalDateTime.now() + "----下午 15:00");
        getFundToRedis();
    }


    /**
     * 每天早上6,7,8,9点获取到，昨日真实净值。
     * 再次获取昨日真实净值，刷新一遍（部分数据可能刷新慢，比如日期未更新的数据）
     */
    @Scheduled(cron = "0 0 6,7,8,9 * * ?")
    private void scheduledToReal() {

        System.err.println("执行静态定时任务时间-----开始同步----昨日真实净值----数据到MySQL-----: " + LocalDateTime.now() + "----每天早上6,7,8,9点");

    }


    /**
     * 定时将基金--估算折线图--信息存入mysql 作为历史数据。
     * ♥ 历史估值折现图。！！！新功能！！！
     * 每天早上4点。
     */
    @Scheduled(cron = "0 0 4 * * ?")
    private void scheduledToEstimate() {

        System.err.println("♥ 历史估算折现图。！！！新功能！！！-----定时将基金折线图信息存入mysql 作为历史数据: " + LocalDateTime.now() + "----每天早上4点");

    }
}
