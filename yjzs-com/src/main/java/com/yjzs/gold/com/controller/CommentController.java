package com.yjzs.gold.com.controller;


import com.yjzs.gold.com.bean.TComment;
import com.yjzs.gold.com.service.TCommentService;
import com.yjzs.gold.com.vo.resp.TComMinVo;
import com.yjzs.gold.com.vo.resp.TComPageListVo;
import com.yjzs.gold.com.vo.resp.TComVo;
import com.yjzs.gold.feign.bean.TUser;
import com.yjzs.gold.feign.clients.TUserClient;
import com.yjzs.gold.utils.AppDateUtils;
import com.yjzs.gold.utils.AppResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tght
 * @RefreshScope 配置自动刷新
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/com/ment")
public class CommentController {


    @Autowired
    TUserClient tUserClient;

    /**
     * 在帖子详细信息的下面
     * 分页查询     无限滚动。
     * 查看改帖子下的所有评论
     * 最新时间排序
     */
    @Autowired
    TCommentService tCommentService;

    /**
     * 查看评论信息     帖子评论 + 其对应的回复评论（回复帖子评论 + 回复评论评论）
     *
     * @return
     * @throws ParseException
     */

    @GetMapping("/select")
    public AppResponse<Object> selectMy(@RequestParam("postId") String postId,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "8") Integer pageSize) throws ParseException {
        AppResponse resp;

        Integer id = Integer.parseInt(postId);
        int total = tCommentService.selectNumZ(id);
        if (total == 0) {
            // 总数为0，就不用去查了
            resp = AppResponse.fail(null);
            resp.setMsg("暂无评论");
            return resp;
        }
        TComPageListVo tComPageListVo = new TComPageListVo();
        tComPageListVo.setTotal(total);

        // 按照分页请求出评论信息
        List<TComment> tComsList = tCommentService.selectComs(postId, pageNum, pageSize);

        if (tComsList == null) {

            resp = AppResponse.fail(null);
            resp.setMsg("到底了哦~");
            return resp;
        }

        // 将查询的信息放入list中。
        List<TComVo> list = new ArrayList<>();
        //遍历获取的主评论信息。
        for (int i = 0; i < tComsList.size(); i++) {
            TComment tComment = tComsList.get(i);
            // 返回信息类
            TComVo tComVo = new TComVo();
            // 将小vo的对象来对拷到大Vo中，date没拷上,data先转成字符串型
            BeanUtils.copyProperties(tComment, tComVo);
            String comDay = AppDateUtils.DateDayToString(tComment.getComDate());
            tComVo.setComDate(comDay);
            // 远程调用， 获取用户信息
            AppResponse<TUser> response = tUserClient.selectUser(tComVo.getUserId().toString());
            TUser tUser = response.getData();
            tComVo.setUserNickName(tUser.getUserNickName());
            tComVo.setUserImgUrl(tUser.getUserImgUrl());
            tComVo.setUserSex(tUser.getUserSex());
            // 子评论的封装放到宁外一个方法上，这里只算子评论总数
            int zTotal = tCommentService.zCountComs(tComVo.getComId());
            tComVo.setZTotal(zTotal);
            // 具体子评论放到另一个请求来获取。
            list.add(tComVo);
        }
        tComPageListVo.setRecords(list);
        resp = AppResponse.ok(tComPageListVo);
        // 成功的消息放到前端，后端写异常消息
        return resp;
    }

    /**
     * 查看子评论
     */
    @GetMapping("/selectZ")
    public AppResponse<Object> selectMyZ(@RequestParam("comId") String comId,
                                         @RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "3") Integer pageSize) throws ParseException {
        AppResponse resp;
        Integer id = Integer.parseInt(comId);
        // 分页根据主评论id找子评论
        List<TComment> tComList = tCommentService.selectComsZ(id, pageNum, pageSize);

        List<TComMinVo> list = new ArrayList<>();
        // 遍历封装一下返回结果
        for (int i = 0; i < tComList.size(); i++) {
            TComment tComment = tComList.get(i);
            // 返回信息类
            TComMinVo tComVo = new TComMinVo();
            // 将小vo的对象来对拷到大Vo中，date没拷上,data先转成字符串型
            BeanUtils.copyProperties(tComment, tComVo);
            String comDay = AppDateUtils.DateDayToString(tComment.getComDate());
            tComVo.setComDate(comDay);

            // 远程调用， 获取用户信息
            AppResponse<TUser> response = tUserClient.selectUser(tComVo.getUserId().toString());
            TUser tUser = response.getData();
            tComVo.setUserNickName(tUser.getUserNickName());
            tComVo.setUserImgUrl(tUser.getUserImgUrl());
            tComVo.setUserSex(tUser.getUserSex());

            if (tComVo.getComType().contains("@")) {
                // 第三类型
                String comType = tComVo.getComType();
                System.out.println(comType+":");
                String[] split = comType.split("@");
                String userId = split[1];
                // 远程调用， 获取用户信息
                AppResponse<TUser> userData = tUserClient.selectUser(userId);
                TUser tUser3 = userData.getData();
                tComVo.setUserNickName3(tUser3.getUserNickName());
                tComVo.setUserSex3(tUser3.getUserSex());
            }
            list.add(tComVo);
        }
        // 到前端再见数据赋值过去
        resp = AppResponse.ok(list);
        // 成功的消息放到前端，后端写异常消息
        return resp;
    }

    /**
     * 发表主评论
     * userId、comConId、内容
     */
    @PostMapping("/toShare")
    public AppResponse<Object> toShare(@RequestBody TComment tComment) throws ParseException {
        AppResponse resp;
        System.out.println(tComment);
        tComment.setComDate(AppDateUtils.getDateTime());
        tComment.setComType("0");
        System.out.println(tComment);
        int i = tCommentService.insertCom(tComment);
        if (i == 1) {
            resp = AppResponse.ok("ok");
            // 成功的消息放到前端，后端写异常消息
            return resp;
        } else {
            resp = AppResponse.fail(null);
            resp.setMsg("评论失败");
            return resp;
        }
    }

    /**
     * 回复主评论
     */
    @PostMapping("/replay")
    public AppResponse<Object> replay(@RequestBody TComment tComment) throws ParseException {
        AppResponse resp;

        tComment.setComDate(AppDateUtils.getDateTime());
        tComment.setComType("1");

        int i = tCommentService.insertCom(tComment);
        if (i == 1) {
            resp = AppResponse.ok("ok");
            // 成功的消息放到前端，后端写异常消息
            return resp;
        } else {
            resp = AppResponse.fail(null);
            resp.setMsg("评论失败");
            return resp;
        }
    }


    /**
     * 回复3类型评论
     * 把类型改成@+用户id
     */
    @PostMapping("/replay3")
    public AppResponse<Object> replay3(@RequestBody TComment tComment) throws ParseException {
        AppResponse resp;
        System.out.println(tComment);
        tComment.setComDate(AppDateUtils.getDateTime());

        int i = tCommentService.insertCom(tComment);
        if (i != 0) {
            resp = AppResponse.ok("ok");
            // 成功的消息放到前端，后端写异常消息
            return resp;
        } else {
            resp = AppResponse.fail(null);
            resp.setMsg("评论失败");
            return resp;
        }
    }

    /**
     * 删除评论
     */
    @DeleteMapping("/delete/{comId}")
    public AppResponse<Object> delete(@PathVariable String comId) {
        AppResponse resp;
        Integer cid = Integer.parseInt(comId);

        // 先检查是否添加了。
        String like = tCommentService.isExit(cid);
        if (like == "0") {
            resp = AppResponse.fail(null);
            resp.setMsg("评论已删除");
            return resp;
        }

        // 放到Service中去转换类型
        int i = tCommentService.delete(comId);
        if (i == 1) {
            resp = AppResponse.ok("ok");
            return resp;
        } else {
            resp = AppResponse.fail(null);
            resp.setMsg("删除评论失败");
            return resp;
        }
    }

}
