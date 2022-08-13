package com.yjzs.gold.user.controller;


import com.yjzs.gold.user.bean.TUser;
import com.yjzs.gold.user.config.OssTemplate;
import com.yjzs.gold.user.service.TUserService;
import com.yjzs.gold.user.vo.req.UserUpdateVo;
import com.yjzs.gold.utils.AppResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.UUID;

/**
 * @author Tght
 * @RefreshScope 配置自动刷新
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/user/my")
public class UserMyController {



    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    TUserService tUserService;

    /**
     * 查看用户信息
     */
    @GetMapping("select")
    public AppResponse<Object> selectUser(@RequestParam("id") String id){
        Integer userId = Integer.parseInt(id);
        TUser tUser = tUserService.selectUserById(userId);
        return AppResponse.ok(tUser);
    }


    /**
     * 更新用户信息
     */
    @PostMapping("/update")
    public AppResponse<Object> userHeadImg(@RequestBody UserUpdateVo vo) {

        int i = tUserService.updateUser(vo);
        if (i == 1){
            return AppResponse.ok("更新成功");
        }else{
            return AppResponse.fail("更新失败");
        }

    }



    /**
     * 修改密码
     */


    /**
     * 修改手机号
     */


    /**
     * 修改邮箱号
     */


    /**
     * 注销账户
     * 修改用户状态为1，表示删除
     */


    /**
     * 更新达人值
     * 每天晚上12：00会对用户帖子的热度或榜单来更新
     */


    /**
     * 修改用户类型
     * 0为管理员1为普通用户
     */

}
