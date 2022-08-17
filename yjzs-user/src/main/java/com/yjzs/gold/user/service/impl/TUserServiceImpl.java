package com.yjzs.gold.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjzs.gold.user.bean.TUser;
import com.yjzs.gold.user.bean.TUserExample;
import com.yjzs.gold.user.mapper.TUserMapper;
import com.yjzs.gold.user.service.TUserService;
import com.yjzs.gold.user.vo.req.UserUpdateVo;
import com.yjzs.gold.user.vo.resp.UserRespVo;
import com.yjzs.gold.utils.AccountORUtils;
import com.yjzs.gold.utils.AppResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author Tght
 * @Transactional(readOnly = true) 用户一般是查询操作比价多。
 * 需要修改的，再单独标上。
 */
@Slf4j
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper,TUser> implements TUserService {

    @Autowired
    TUserMapper tUserMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public int saveUser(UserRespVo vo) {
        try {
            TUser tUser = new TUser();

            if (vo.getUserAccount() == null){
                tUser.setUserEmail(vo.getUserEmail());
            }else {
                tUser.setUserAccount(vo.getUserAccount());
            }
            tUser.setUserNickName(vo.getUserNickName());
            tUser.setUserPassword(vo.getUserPassword());
            tUser.setUserCreateTime(vo.getUserCreateTime());
            tUser.setUserStatus(vo.getUserStatus());
            tUser.setUserType(vo.getUserType());
//            int insert = tUserMapper.insert(tUser);
            int i = tUserMapper.insertSelective(tUser);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("注册失败-{}", e.getMessage());
            //  throw new UserException("保存会员业务逻辑失败！");
            return 0;
        }
    }

    @Override
    public TUser getUserbyLogin(String account, String password) {
        TUser tUser;
        // 需要校验账户为手机号OR邮箱。
        AppResponse<String> response = AccountORUtils.checkAccount(account);
        // 邮箱注册
        String emailStr = "email";
        String phoneStr = "phone";
        if (response.getData() == emailStr) {
            TUserExample example = new TUserExample();
            example.createCriteria().andUserEmailEqualTo(account);
            List<TUser> list = tUserMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                return null;
            } else {
                tUser = list.get(0);
                // BCrypt加密
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                //密码比较，将用户输入的密码与数据库中拿出来的对比
                // matches编码器，将原始密码和数据库中加密过的给他就好。
                if (!encoder.matches(password, tUser.getUserPassword())) {
                    return null;
                }else {
                    return tUser;
                }
            }
            // 手机号注册
        } else if (response.getData() == phoneStr) {
            TUserExample example = new TUserExample();
            example.createCriteria().andUserAccountEqualTo(account);
            List<TUser> list = tUserMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                return null;
            } else {
                tUser = list.get(0);
                // BCrypt加密
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                //密码比较，将用户输入的密码与数据库中拿出来的对比
                // matches编码器，将原始密码和数据库中加密过的给他就好。
                if (!encoder.matches(password, tUser.getUserPassword())) {
                    return null;
                }else {
                    return tUser;
                }
            }
        } else {
            return null;
        }
    }

    @Override
    public TUser getUserbyEmail(String account) {
        TUserExample example = new TUserExample();
        example.createCriteria().andUserEmailEqualTo(account);
        TUser tUser;
        List<TUser> list = tUserMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            tUser = null;
        } else {
            tUser = list.get(0);
        }
        return tUser;
    }

    @Override
    public TUser getUserbyPhone(String account) {
        TUserExample example = new TUserExample();
        example.createCriteria().andUserAccountEqualTo(account);
        TUser tUser;
        List<TUser> list = tUserMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            tUser = null;
        } else {
            tUser = list.get(0);
        }
        return tUser;
    }

    @Override
    public TUser getUserbyNicker(String userNickName) {
        TUserExample example = new TUserExample();
        example.createCriteria().andUserNickNameEqualTo(userNickName);
        TUser tUser;
        List<TUser> list = tUserMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            tUser = null;
        } else {
            tUser = list.get(0);
        }
        return tUser;
    }

    @Override
    public TUser getUserbyId(Integer id) {
        return null;
    }

    @Override
    public int updateUser(UserUpdateVo vo) {
        TUserExample example = new TUserExample();

        example.createCriteria().andUserIdEqualTo(Integer.parseInt(vo.getUserId()));
        TUser tUser;
        List<TUser> list = tUserMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            tUser = null;
        } else {
            tUser = list.get(0);
        }

        tUser.setUserNickName(vo.getUserNickName());
        tUser.setUserSex(vo.getUserSex());
        tUser.setUserImgUrl(vo.getUserImgUrl());
        int i = tUserMapper.updateByExampleSelective(tUser, example);
        return i;
    }

    @Override
    public TUser selectUserById(Integer id) {
        TUserExample example = new TUserExample();
        example.createCriteria().andUserIdEqualTo(id);
        TUser tUser;
        List<TUser> list = tUserMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            tUser = null;
        } else {
            tUser = list.get(0);
        }
        return  tUser;
    }

}
