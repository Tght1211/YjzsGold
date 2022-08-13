package com.yjzs.gold.com.controller;


import com.yjzs.gold.com.bean.TLike;
import com.yjzs.gold.com.service.TLikeService;
import com.yjzs.gold.utils.AppDateUtils;
import com.yjzs.gold.utils.AppResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author Tght
 * @RefreshScope 配置自动刷新
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/com/like")
public class LikeController {

    @Autowired
    TLikeService tLikeService;

    /**
     * 添加帖子到喜欢
     */
    @GetMapping("/add")
    public AppResponse<Object> add(@RequestParam("userId") String userId,@RequestParam("posId") String posId) throws ParseException {
        AppResponse resp;
        Integer pid = Integer.parseInt(posId);
        Integer uid = Integer.parseInt(userId);

        // 先检查是否添加了。
        String like = tLikeService.isLike(pid, userId);
        if (like == "1"){
            resp = AppResponse.fail(null);
            resp.setMsg("您已点赞");
            return resp;
        }
        TLike tLike = new TLike();
        tLike.setPosId(pid);
        tLike.setUserId(uid);
        tLike.setLikeDate(AppDateUtils.getDateTime());
        int i = tLikeService.addLike(tLike);
        if (i==1){
            return AppResponse.ok("ok");
        }else {
            resp = AppResponse.fail(null);
            resp.setMsg("点赞失败");
            return resp;
        }
    }

    /**
     * 从喜欢中移除帖子
     */
    @DeleteMapping("/delete/{posId}/{userId}")
    public AppResponse<Object> delete( @PathVariable String posId,@PathVariable String userId){
        AppResponse resp;
        Integer pid = Integer.parseInt(posId);

        // 先检查是否添加了。
        String like = tLikeService.isLike(pid, userId);
        if (like == "0"){
            resp = AppResponse.fail(null);
            resp.setMsg("您未点赞");
            return resp;
        }

        // 放到Service中去转换类型
        int i = tLikeService.delete(posId,userId);
        if (i == 1){
            resp = AppResponse.ok("ok");
            return resp;
        }else {
            resp = AppResponse.fail(null);
            resp.setMsg("取消点赞失败");
            return resp;
        }
    }

}
