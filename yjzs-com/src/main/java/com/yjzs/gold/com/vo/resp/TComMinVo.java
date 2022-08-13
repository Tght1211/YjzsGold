package com.yjzs.gold.com.vo.resp;

import lombok.Data;

import java.util.Date;

@Data
public class TComMinVo {

    /**
     * 子评论的用户信息
     * 为类型为第三种再赋值3信息
     */

    private String userNickName;

    private String userSex;

    private String userImgUrl;

    private String userNickName3;

    private String userSex3;

    /**
     * 评论信息部分
     */

    private Integer comId;

    private Integer userId;

    private Integer comConId;

    private String comContent;

    /**
     * 每个传回前端的data都要转为String
     */
    private String comDate;

    private String comType;

    private Integer posId;
}
