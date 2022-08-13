package com.yjzs.gold.user.vo.req;


import lombok.Data;

import java.util.Date;

/**
 * @author Tght
 */
@Data
public class UserMyVo {

    private Integer userId;

    private String userNickName;

    private String userAccount;

    private String userPassword;

    private Date userCancelTime;

    private String userEmail;

    private String userStatus;

    private Integer userPlate;

    private String userImgUrl;
}
