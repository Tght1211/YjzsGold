package com.yjzs.gold.main.vo.resp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OptVo {

    private Integer optId;

    private Integer userId;

    private Integer fundId;

   //下面有了，用不到 private BigDecimal fundZrjz;

    private BigDecimal optPrice;

    // 天数，自选日期不用传出去
    private int days;
    // 百分比。（昨日-持有时） /  持有时  * 100
    private String optProfitProp;



    private String fundStatus;

    private String fundCode;

    private String name;
    /**
     * 从API获取的日期先用String。
     */
    private String jzrq;

    private BigDecimal dwjz;

    private BigDecimal gsz;

    private BigDecimal gszzl;

    private String gztime;

    /**
     * 是否持有1为持有，0为初始状态。
     */
    private String chiY;

    /**
     * 是否自选
     */
    private String zhiX;

}
