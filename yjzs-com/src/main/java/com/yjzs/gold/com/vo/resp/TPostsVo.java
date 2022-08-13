package com.yjzs.gold.com.vo.resp;

import lombok.Data;

import java.util.Date;

@Data
public class TPostsVo {
    // 帖子id
    private Integer posId;
    // 用户id
    private Integer userId;
    // 标题
    private String posTitle;
    // 帖子内容
    private String posContent;
    // 帖子日期,注意，Data数据得转为String
    private String posDate;
    // 帖子热度
    private Integer posHot;
    // 帖子状态 （0为正常，1为删除状态）
    private String posStatus;
    // 帖子类型 （0公开，1私有）
    private String posType;
    // 举报状态·（默认0正常，1为嫌疑，2为举报成功）
    private String posOff;

    // 头像
    private String userImgUrl;
    // 昵称
    private String userNickName;
    // 性别  （1为男，0为女，默认为2，表示未知）
    private String userSex = "2";

    // 点赞数 ：这个可以算出来，
    // 只要 ⭐ **获取赞得算：帖子热度 - 被收藏数X10 - 评论数*X 5 = 点赞数**⭐
    // posHot - colNum*10 - comNum*5  = 点赞数。
    private int likeNum;
    // 评论数
    private int comNum;
    // 收藏数
    private int colNum;

    //与用户关系  为1 的都边红色按钮，
    // 是否点赞 0为false，1为true
    private String isLike;
    // 是否评论 0为false，1为true ,检测到有评论OR回复就为1
    private String isCom;
    // 是否收藏  0为false，1为true
    private String isCol;

}
