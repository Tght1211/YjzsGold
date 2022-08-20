package com.yjzs.gold.utils;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.*;


/**
 * @author Tght
 * 基金定时获取
 */

public class FundTime {

    /**
     * 一、创建线程池的7个参数
     * 1、corePoolSize线程池的核心线程数
     * 2、maximumPoolSize能容纳的最大线程数
     * 3、keepAliveTime空闲线程存活时间
     * 4、unit 存活的时间单位
     * 5、workQueue 存放提交但未执行任务的队列
     * 6、threadFactory 创建线程的工厂类
     * 7、handler 等待队列满后的拒绝策略
     * <p>
     * <p>
     * * 9:30 - 11:30  13:00 - 15:00   总共240分钟。
     * * 这个时间段可以执行获取基金信息
     */


    public static void getFund(String[] arr, Integer x) {

        //1.开线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
        // i表示创建线程的数量，s，t，查询数组开始的时间，t-s+1 = 一个线程更新的基金条数
        for (int i = 0; i < x; i++) {
//            int s = i * 2, e = s + 1;
            // 求出每个线程需要存储的数据条数
            int len = (arr.length / x) + 1;
            // 线程获取资源分配
            int start = len * i, end = start + len;
            MyRunable mc = new MyRunable(start, end, arr);
            executorService.execute(mc);
        }
        executorService.shutdown();
    }
}
