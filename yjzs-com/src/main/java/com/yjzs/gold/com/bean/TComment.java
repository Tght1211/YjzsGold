package com.yjzs.gold.com.bean;

import lombok.ToString;

import java.util.Date;

@ToString
public class TComment {
    private Integer comId;

    private Integer userId;

    private Integer comConId;

    private String comContent;

    private Date comDate;

    private String comType;

    private Integer posId;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getComConId() {
        return comConId;
    }

    public void setComConId(Integer comConId) {
        this.comConId = comConId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent == null ? null : comContent.trim();
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType == null ? null : comType.trim();
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }
}