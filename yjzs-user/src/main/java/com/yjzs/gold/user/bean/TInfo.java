package com.yjzs.gold.user.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TInfo {
    private Integer infoId;

    private Integer userId;

    private BigDecimal infoTotalMoney;

    private BigDecimal infoOccupyMoney;

    private BigDecimal infoYjzsProfit;

    private BigDecimal infoYjzsTomProfit;

    private Date infoDate;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getInfoTotalMoney() {
        return infoTotalMoney;
    }

    public void setInfoTotalMoney(BigDecimal infoTotalMoney) {
        this.infoTotalMoney = infoTotalMoney;
    }

    public BigDecimal getInfoOccupyMoney() {
        return infoOccupyMoney;
    }

    public void setInfoOccupyMoney(BigDecimal infoOccupyMoney) {
        this.infoOccupyMoney = infoOccupyMoney;
    }

    public BigDecimal getInfoYjzsProfit() {
        return infoYjzsProfit;
    }

    public void setInfoYjzsProfit(BigDecimal infoYjzsProfit) {
        this.infoYjzsProfit = infoYjzsProfit;
    }

    public BigDecimal getInfoYjzsTomProfit() {
        return infoYjzsTomProfit;
    }

    public void setInfoYjzsTomProfit(BigDecimal infoYjzsTomProfit) {
        this.infoYjzsTomProfit = infoYjzsTomProfit;
    }

    public Date getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(Date infoDate) {
        this.infoDate = infoDate;
    }
}