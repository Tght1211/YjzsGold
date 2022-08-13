package com.yjzs.gold.com.bean;

import java.util.Date;

public class  TPosts {
    private Integer posId;

    private Integer userId;

    private String posTitle;

    private String posContent;

    private Date posDate;

    private Integer posHot;

    private String posStatus;

    private String posType;

    private String posOff;

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPosTitle() {
        return posTitle;
    }

    public void setPosTitle(String posTitle) {
        this.posTitle = posTitle == null ? null : posTitle.trim();
    }

    public String getPosContent() {
        return posContent;
    }

    public void setPosContent(String posContent) {
        this.posContent = posContent == null ? null : posContent.trim();
    }

    public Date getPosDate() {
        return posDate;
    }

    public void setPosDate(Date posDate) {
        this.posDate = posDate;
    }

    public Integer getPosHot() {
        return posHot;
    }

    public void setPosHot(Integer posHot) {
        this.posHot = posHot;
    }

    public String getPosStatus() {
        return posStatus;
    }

    public void setPosStatus(String posStatus) {
        this.posStatus = posStatus == null ? null : posStatus.trim();
    }

    public String getPosType() {
        return posType;
    }

    public void setPosType(String posType) {
        this.posType = posType == null ? null : posType.trim();
    }

    public String getPosOff() {
        return posOff;
    }

    public void setPosOff(String posOff) {
        this.posOff = posOff == null ? null : posOff.trim();
    }
}