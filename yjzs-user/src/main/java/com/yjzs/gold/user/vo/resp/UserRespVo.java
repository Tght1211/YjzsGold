package com.yjzs.gold.user.vo.resp;

import lombok.Data;

import java.util.Date;

/**
 * @author Tght
 */
@Data
public class UserRespVo {
    /**
     * 令牌 登陆后会分配给当前用户一个临时令牌值，
     * 以后对系统的任何访问都必须携带这个令牌值，
     * 否者拒绝访问。必须去登录。
     * （令牌值不在就说明没登录）
     */
    private String accessToken;

    private Integer userId;

    private String userNickName;

    private String userAccount;

    private String userPassword;

    private String userType;

    private Date userCreateTime;

    private Date userCancelTime;

    private String userEmail;

    private String userStatus;

    private Integer userPlate;

    private String userImgUrl;

    private String userSex;

}
