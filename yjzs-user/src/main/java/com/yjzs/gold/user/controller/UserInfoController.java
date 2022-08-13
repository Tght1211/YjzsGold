package com.yjzs.gold.user.controller;

import com.yjzs.gold.user.bean.TInfo;
import com.yjzs.gold.user.service.TInfoService;
import com.yjzs.gold.utils.AppResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Tght
 * @RefreshScope 配置自动刷新
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/user/info")
public class UserInfoController {

    @Autowired
    TInfoService tInfoService;


    @Autowired
    StringRedisTemplate stringRedisTemplate;


    /**
     * 查看投资信息
     */
    @GetMapping("/select/{id}")
    public AppResponse<Object> selectInfo(@PathVariable("accessToken") String accessToken) {

        String id = stringRedisTemplate.opsForValue().get(accessToken);
        if (id == null) {
            AppResponse resp = AppResponse.fail(null);
            resp.setMsg("请重新登录");
            return resp;
        }
        TInfo tInfo = tInfoService.getInfobyUserId(Integer.parseInt(id));
        return AppResponse.ok(tInfo);
    }














    /**
     * 修改投资信息
     * 第一次修改为添加
     * 这里的金额需要涉及改变类型
     */
    @PostMapping("/updateInfo")
    public AppResponse<Object> updateInfo(@RequestParam("id") String id, @RequestParam("totalMoney") String totalMoney) {
        TInfo tInfo = tInfoService.getInfobyUserId(Integer.parseInt(id));
        int i = 0;
        if (tInfo == null) {
            // 第一次修改为添加
            TInfo info = new TInfo();
            info.setUserId(Integer.parseInt(id));
            info.setInfoTotalMoney(new BigDecimal(totalMoney));
            info.setInfoDate(new Date());
            i = tInfoService.saveInfo(info);
        } else {
            // 更新
            tInfo.setInfoTotalMoney(new BigDecimal(totalMoney));
            i = tInfoService.updateInfo(tInfo);
        }
        if (i == 1) {
            AppResponse resp = AppResponse.ok("ok");
            resp.setMsg("设置成功");
            return resp;
        } else {
            AppResponse resp = AppResponse.fail(null);
            resp.setMsg("设置失败");
            return resp;
        }
    }
}
