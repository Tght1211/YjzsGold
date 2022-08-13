package com.yjzs.gold.main.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TOperation {
    private Integer opeId;

    private Integer userId;

    private Integer fundId;

    private BigDecimal opeMoney;

    private BigDecimal opePrice;

    private BigDecimal opeNum;

    private Date opeDate;

    private String opeStatus;

    private String opeTepe;

    public Integer getOpeId() {
        return opeId;
    }

    public void setOpeId(Integer opeId) {
        this.opeId = opeId;
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

    public BigDecimal getOpeMoney() {
        return opeMoney;
    }

    public void setOpeMoney(BigDecimal opeMoney) {
        this.opeMoney = opeMoney;
    }

    public BigDecimal getOpePrice() {
        return opePrice;
    }

    public void setOpePrice(BigDecimal opePrice) {
        this.opePrice = opePrice;
    }

    public BigDecimal getOpeNum() {
        return opeNum;
    }

    public void setOpeNum(BigDecimal opeNum) {
        this.opeNum = opeNum;
    }

    public Date getOpeDate() {
        return opeDate;
    }

    public void setOpeDate(Date opeDate) {
        this.opeDate = opeDate;
    }

    public String getOpeStatus() {
        return opeStatus;
    }

    public void setOpeStatus(String opeStatus) {
        this.opeStatus = opeStatus == null ? null : opeStatus.trim();
    }

    public String getOpeTepe() {
        return opeTepe;
    }

    public void setOpeTepe(String opeTepe) {
        this.opeTepe = opeTepe == null ? null : opeTepe.trim();
    }


}