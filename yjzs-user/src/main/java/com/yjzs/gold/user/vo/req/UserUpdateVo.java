package com.yjzs.gold.user.vo.req;

import lombok.Data;


@Data
public class UserUpdateVo {
    private String userId;

    private String userNickName;

    private String userImgUrl;

    private String userSex;
}
