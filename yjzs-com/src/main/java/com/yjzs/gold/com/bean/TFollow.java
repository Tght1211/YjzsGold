package com.yjzs.gold.com.bean;

import java.util.Date;

public class TFollow {
    private Integer follId;

    private Integer startUserId;

    private Integer fansUserId;

    private Date follDate;

    public Integer getFollId() {
        return follId;
    }

    public void setFollId(Integer follId) {
        this.follId = follId;
    }

    public Integer getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(Integer startUserId) {
        this.startUserId = startUserId;
    }

    public Integer getFansUserId() {
        return fansUserId;
    }

    public void setFansUserId(Integer fansUserId) {
        this.fansUserId = fansUserId;
    }

    public Date getFollDate() {
        return follDate;
    }

    public void setFollDate(Date follDate) {
        this.follDate = follDate;
    }
}