package com.yjzs.gold.user.vo.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Tght
 */
@Data
public class UserRegistVo implements Serializable {

    private String nickName;

    private String account;

    private String userpswd;

    private String confirm;

    private String code;

}
