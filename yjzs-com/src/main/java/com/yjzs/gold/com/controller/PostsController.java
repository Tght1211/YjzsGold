package com.yjzs.gold.com.controller;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import com.yjzs.gold.com.bean.TPosts;
import com.yjzs.gold.com.config.OssTemplate;
import com.yjzs.gold.com.service.TCollectService;
import com.yjzs.gold.com.service.TCommentService;
import com.yjzs.gold.com.service.TLikeService;
import com.yjzs.gold.com.service.TPostsService;
import com.yjzs.gold.com.vo.resp.TPostsMinVo;
import com.yjzs.gold.com.vo.resp.TPostsPageListVo;
import com.yjzs.gold.com.vo.resp.TPostsVo;
import com.yjzs.gold.feign.bean.TUser;
import com.yjzs.gold.feign.clients.TUserClient;
import com.yjzs.gold.utils.AppDateUtils;
import com.yjzs.gold.utils.AppResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Tght
 * @RefreshScope 配置自动刷新
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/com/posts")
public class PostsController {
    @Autowired
    OssTemplate ossTemplate;

    @Autowired
    TPostsService tPostsService;

    @Autowired
    TCollectService tCollectService;

    @Autowired
    TCommentService tCommentService;

    @Autowired
    TLikeService tLikeService;

    @Autowired
    TUserClient tUserClient;

    /**
     * 富文本上传接口
     * 搞定！
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/editor")
    public JSON editorUpload(MultipartFile file) throws Exception {
        //获取文件名称
        String filename = file.getOriginalFilename();
        // 定义文件的唯一标识（前缀） uuid
        filename = UUID.randomUUID().toString().replaceAll("-", "") + "-" + filename;
        //  // 文件的路径
        String filePath = ossTemplate.upload(filename, file.getInputStream());
        // 返回结果URL
        String url = filePath;
        JSONObject json = new JSONObject();
        json.set("errno", 0);
        JSONArray array = new JSONArray();
        JSONObject data = new JSONObject();
        array.add(data);
        data.set("url", url);
        json.set("data", array);
        return json;
    }

    /**
     * 添加帖子
     */
    @PostMapping("/save")
    public AppResponse<Object> save(@RequestBody TPosts tPosts) throws ParseException {
        tPosts.setPosDate(AppDateUtils.getDateTime());
        tPosts.setPosHot(0);
        // （0为正常，1为删除状态 ） 用户只能改状态，管理员可以删除
        tPosts.setPosStatus("0");
        // 举报状态  默认0正常，1为嫌疑，2为举报成功
        tPosts.setPosOff("0");
        int i = tPostsService.insertPost(tPosts);
        if (i == 1) {
            return AppResponse.ok("ok");
        } else {
            return AppResponse.fail(null);
        }
    }

    /**
     * 查看我的全部帖子
     * 4个小属性
     */
    @GetMapping("/selectMyMin")
    public AppResponse<Object> selectMyMin(@RequestParam("userId") String userId) throws ParseException {
        List<TPosts> tPosts = tPostsService.selectMy(userId);
        List<TPostsMinVo> tPostsMinVos = new ArrayList<>();
        for (int i = 0; i < tPosts.size(); i++) {
            TPosts posts = tPosts.get(i);
            TPostsMinVo tPostsMinVo = new TPostsMinVo();
            // 日期
            String postsDay = AppDateUtils.DateDayToString(posts.getPosDate());
            tPostsMinVo.setPosDate(postsDay);
            // 标题
            tPostsMinVo.setPosTitle(posts.getPosTitle());
            // 私有还是公开
            tPostsMinVo.setPosType(posts.getPosType());
            // 热度
            tPostsMinVo.setPosHot(posts.getPosHot());
            tPostsMinVos.add(tPostsMinVo);
        }
        return AppResponse.ok(tPostsMinVos);
    }


    /**
     * 查看我的帖子
     */
    @GetMapping("/selectMy")
    public AppResponse<Object> selectMy(@RequestParam("userId") String userId,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "3") Integer pageSize) throws ParseException {
        AppResponse resp;

        TPostsPageListVo tPostsPageListVo = new TPostsPageListVo();
        int total = tPostsService.countMyPosts(userId);
        tPostsPageListVo.setTotal(total);
        // 远程调用， 获取用户信息
        AppResponse<TUser> response = tUserClient.selectUser(userId);
        if (response.getData() == null) {
            resp = AppResponse.fail(null);
            resp.setMsg("获取我的帖子失败");
            return resp;
        }
        TUser tUser = response.getData();

        // 页面表示第几次请求，pageSize表示，一次请求几个数据
        List<TPosts> tPostsList = tPostsService.selectMy(userId, pageNum, pageSize);
        if (tPostsList == null) {
            resp = AppResponse.fail(null);
            resp.setMsg("到底了哦~");
            return resp;
        }
        List<TPostsVo> list = new ArrayList<>();
        for (int i = 0; i < tPostsList.size(); i++) {
            // 获取查询的数据
            TPosts tPosts = tPostsList.get(i);
            // 创建返回对象
            TPostsVo tPostsVo = new TPostsVo();
            // 将小vo的对象来对拷到大Vo中，date没拷上
            BeanUtils.copyProperties(tPosts, tPostsVo);
            String postsDay = AppDateUtils.DateDayToString(tPosts.getPosDate());
            tPostsVo.setPosDate(postsDay);

            // 添加上个人信息,根据id，在外面只要查一次
            tPostsVo.setUserImgUrl(tUser.getUserImgUrl());
            tPostsVo.setUserNickName(tUser.getUserNickName());
            tPostsVo.setUserSex(tUser.getUserSex());
            // 添加上,根据帖子id来查的评论数和收藏数，这里要花费很多性能
            // 收藏数
            int colNum = tCollectService.selectNum(tPosts.getPosId());
            // 评论数
            int comNum = tCommentService.selectNum(tPosts.getPosId());
            // 点赞数
            int likeNum = tLikeService.selectNum(tPosts.getPosId());
            // int likeNum = tPosts.getPosHot() - colNum * 10 - comNum * 5;
            // 每次查询也要更新热度
            tPostsVo.setPosHot(likeNum + comNum * 5 + colNum * 10);
            tPosts.setPosHot(likeNum + comNum * 5 + colNum * 10);
            // 去更新postId的posHot
            int a = tPostsService.update(tPosts);
            if (a == 0) {
                resp = AppResponse.fail(null);
                resp.setMsg("热度更新失败");
                return resp;
            }
            // 收藏、评论、点赞。
            tPostsVo.setColNum(colNum);
            tPostsVo.setComNum(comNum);
            tPostsVo.setLikeNum(likeNum);
            // 是否收藏、评论、点赞了  是1否0
            String isCol = tCollectService.isCollect(tPosts.getPosId(), userId);
            String isCom = tCommentService.isComment(tPosts.getPosId(), userId);
            String isLike = tLikeService.isLike(tPosts.getPosId(), userId);
            tPostsVo.setIsCol(isCol);
            tPostsVo.setIsCom(isCom);
            tPostsVo.setIsLike(isLike);
            // 最后放到传出去的集合中
            list.add(tPostsVo);
        }
        tPostsPageListVo.setRecords(list);
        resp = AppResponse.ok(tPostsPageListVo);
        // 成功消息放前端写，后端只写异常消息
        return resp;
    }


    /**
     * 更新我的帖子，更新这里用户，可以选择删除，其实是改了状态。
     */


    /**
     * 删除我的帖子,
     * 管理员操作
     */
    /**
     * 普通用户更新状态。软删除
     * @param posId
     * @return
     */
    @DeleteMapping("/delete/{posId}")
    public AppResponse<Object> deleteUp(@PathVariable String posId) {
        AppResponse resp;
        Integer cid = Integer.parseInt(posId);

        // 放到Service中去转换类型
        int i = tPostsService.delete(cid);
        if (i == 1) {
            resp = AppResponse.ok("ok");
            return resp;
        } else {
            resp = AppResponse.fail(null);
            resp.setMsg("删除帖子失败");
            return resp;
        }
    }



    /**
     * 查看最新的所有帖子
     */
    @GetMapping("/selectNew")
    public AppResponse<Object> selectNew(@RequestParam("userId") String userId,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "3") Integer pageSize) throws ParseException {
        AppResponse resp;

        TPostsPageListVo tPostsPageListVo = new TPostsPageListVo();
        // 总帖子数
        int total = tPostsService.countPosts();
        tPostsPageListVo.setTotal(total);

        // 页面表示第几次请求，pageSize表示，一次请求几个数据
        List<TPosts> tPostsList = tPostsService.selectNew(pageNum, pageSize);
        if (tPostsList == null) {
            resp = AppResponse.fail(null);
            resp.setMsg("到底了哦~");
            return resp;
        }
        List<TPostsVo> list = new ArrayList<>();

        for (int i = 0; i < tPostsList.size(); i++) {
            // 获取查询的数据
            TPosts tPosts = tPostsList.get(i);
            // 创建返回对象
            TPostsVo tPostsVo = new TPostsVo();
            // 将小vo的对象来对拷到大Vo中，date没拷上
            BeanUtils.copyProperties(tPosts, tPostsVo);
            String postsDay = AppDateUtils.DateDayToString(tPosts.getPosDate());
            tPostsVo.setPosDate(postsDay);

            // 远程调用， 获取用户信息
            AppResponse<TUser> res = tUserClient.selectUser(tPostsVo.getUserId().toString());
            if (res.getData() == null) {
                resp = AppResponse.fail(null);
                resp.setMsg("用户信息异常");
                return resp;
            }
            TUser data = res.getData();
            // 添加上个人信息,根据id，在外面只要查一次,这个要区分开
            tPostsVo.setUserImgUrl(data.getUserImgUrl());
            tPostsVo.setUserNickName(data.getUserNickName());
            tPostsVo.setUserSex(data.getUserSex());
            // 添加上,根据帖子id来查的评论数和收藏数，这里要花费很多性能
            // 收藏数
            int colNum = tCollectService.selectNum(tPosts.getPosId());
            // 评论数
            int comNum = tCommentService.selectNum(tPosts.getPosId());
            // 点赞数
            int likeNum = tLikeService.selectNum(tPosts.getPosId());
            // int likeNum = tPosts.getPosHot() - colNum * 10 - comNum * 5;
            // 每次查询也要更新热度
            tPostsVo.setPosHot(likeNum + comNum * 5 + colNum * 10);
            tPosts.setPosHot(likeNum + comNum * 5 + colNum * 10);
            // 去更新postId的posHot
            int a = tPostsService.update(tPosts);
            if (a == 0) {
                resp = AppResponse.fail(null);
                resp.setMsg("热度更新失败");
                return resp;
            }
            // 收藏、评论、点赞。
            tPostsVo.setColNum(colNum);
            tPostsVo.setComNum(comNum);
            tPostsVo.setLikeNum(likeNum);
            // 是否收藏、评论、点赞了  是1否0
            String isCol = tCollectService.isCollect(tPosts.getPosId(), userId);
            String isCom = tCommentService.isComment(tPosts.getPosId(), userId);
            String isLike = tLikeService.isLike(tPosts.getPosId(), userId);
            tPostsVo.setIsCol(isCol);
            tPostsVo.setIsCom(isCom);
            tPostsVo.setIsLike(isLike);
            // 最后放到传出去的集合中
            list.add(tPostsVo);
        }
        tPostsPageListVo.setRecords(list);
        resp = AppResponse.ok(tPostsPageListVo);
        // 成功消息放前端写，后端只写异常消息
        return resp;
    }

    /**
     * 查看最热的所有帖子
     */

    /**
     * 查看关注用户发的帖子
     */
}
