package com.yjzs.gold.com.vo.resp;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Tght
 */
@Data
public class TComVo {
    /**
     * 子评论
     * 有俩种
     */
    private List<TComMinVo> minList;

    private Integer zTotal;

    /**
     * 用户信息部分 ：
     * 昵称、性别、头像   第三种情况信息（昵称+性别）根据类型种的“@id”来获取，只有类型id不为0或1，才去弄
     */

    private String userNickName;

    private String userSex;

    private String userImgUrl;

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
    private String  comDate;

    private String comType;

    private Integer posId;
}
