package com.yjzs.gold.user.service;

import com.yjzs.gold.user.bean.TUser;
import com.yjzs.gold.user.vo.req.UserUpdateVo;
import com.yjzs.gold.user.vo.resp.UserRespVo;

/**
 * @author Tght
 */
public interface TUserService {

    int saveUser(UserRespVo vo);

    TUser getUserbyLogin(String account, String password);

    TUser getUserbyEmail(String account);

    TUser getUserbyPhone(String account);

    TUser getUserbyNicker(String userNickName);

    TUser getUserbyId(Integer id);


    int updateUser(UserUpdateVo vo);

    TUser selectUserById(Integer id);
}
