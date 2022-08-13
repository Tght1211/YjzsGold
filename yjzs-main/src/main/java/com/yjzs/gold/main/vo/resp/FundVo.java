package com.yjzs.gold.main.vo.resp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundVo {
    /**
     * 有这个状态，共有8个数据 +2
     */
    private String fundStatus;

    private String fundCode;

    private String fundName;

    /**
     * 是否持有1为持有，0为初始状态。
     */
    private String chiY;

    /**
     * 净值日期
     */
    private String jzrq;

    /**
     * 当晚净值
     */
    private String dwjz;

    /**
     * 估算值
     */
    private String gsz;

    /**
     * 估算涨跌率
     * 方法三：BigDecimal的setScale方法
     *
     * double f = 111231.5585;
     *
     * BigDecimal bg = new BigDecimal(f);
     * double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
     * System.out.println(f1);
     *
     *         String str="-2.30";
     *         BigDecimal bd=new BigDecimal(str);
     *         System.out.println(bd);
     */
    private BigDecimal gszzl;

    /**
     * 估算时间
     */
    private String gztime;
    /**
     * 持有人数
     */
    private int num;

    /**
     * 是否自选
     */
    private String zhiX;
}
