package com.yjzs.gold.main.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TSupport {
    private Integer supId;

    private Integer userId;

    private Integer fundId;

    private BigDecimal fundZrjz;

    private BigDecimal supMoney;

    private BigDecimal supPrice;

    private BigDecimal supNum;

    private BigDecimal supProfit;

    private BigDecimal supTotalMoney;

    private Date suoDate;

    private String supStatus;

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
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

    public BigDecimal getFundZrjz() {
        return fundZrjz;
    }

    public void setFundZrjz(BigDecimal fundZrjz) {
        this.fundZrjz = fundZrjz;
    }

    public BigDecimal getSupMoney() {
        return supMoney;
    }

    public void setSupMoney(BigDecimal supMoney) {
        this.supMoney = supMoney;
    }

    public BigDecimal getSupPrice() {
        return supPrice;
    }

    public void setSupPrice(BigDecimal supPrice) {
        this.supPrice = supPrice;
    }

    public BigDecimal getSupNum() {
        return supNum;
    }

    public void setSupNum(BigDecimal supNum) {
        this.supNum = supNum;
    }

    public BigDecimal getSupProfit() {
        return supProfit;
    }

    public void setSupProfit(BigDecimal supProfit) {
        this.supProfit = supProfit;
    }

    public BigDecimal getSupTotalMoney() {
        return supTotalMoney;
    }

    public void setSupTotalMoney(BigDecimal supTotalMoney) {
        this.supTotalMoney = supTotalMoney;
    }

    public Date getSuoDate() {
        return suoDate;
    }

    public void setSuoDate(Date suoDate) {
        this.suoDate = suoDate;
    }

    public String getSupStatus() {
        return supStatus;
    }

    public void setSupStatus(String supStatus) {
        this.supStatus = supStatus == null ? null : supStatus.trim();
    }

}