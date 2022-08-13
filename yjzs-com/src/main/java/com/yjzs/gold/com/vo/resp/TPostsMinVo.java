package com.yjzs.gold.com.vo.resp;

import lombok.Data;

@Data
public class TPostsMinVo {
    // 帖子日期,注意，Data数据得转为String
    private String posDate;
    // 标题
    private String posTitle;
    // 帖子类型 （0公开，1私有）
    private String posType;
    // 帖子热度
    private Integer posHot;
}
