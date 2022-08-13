package com.yjzs.gold.main.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TOptional {
    private Integer optId;

    private Integer userId;

    private Integer fundId;

    private BigDecimal optPrice;

    private Date optDate;

    public Integer getOptId() {
        return optId;
    }

    public void setOptId(Integer optId) {
        this.optId = optId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public BigDecimal getOptPrice() {
        return optPrice;
    }

    public void setOptPrice(BigDecimal optPrice) {
        this.optPrice = optPrice;
    }

    public Date getOptDate() {
        return optDate;
    }

    public void setOptDate(Date optDate) {
        this.optDate = optDate;
    }
}