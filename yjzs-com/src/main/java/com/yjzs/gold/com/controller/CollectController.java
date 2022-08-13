package com.yjzs.gold.com.controller;

import com.yjzs.gold.com.bean.TCollect;
import com.yjzs.gold.com.bean.TPosts;
import com.yjzs.gold.com.service.TCollectService;
import com.yjzs.gold.com.service.TCommentService;
import com.yjzs.gold.com.service.TLikeService;
import com.yjzs.gold.com.service.TPostsService;
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
@RequestMapping("/com/collect")
public class CollectController {
    @Autowired
    TLikeService tLikeService;

    @Autowired
    TCommentService tCommentService;


    @Autowired
    TCollectService tCollectService;

    @Autowired
    TPostsService tPostsService;

    @Autowired
    TUserClient tUserClient;
    /**
     * 查看我收藏的帖子。
     * 注意要去@Service中分页
     */
    @GetMapping("/select")
    public AppResponse<Object> selectMy(@RequestParam("userId") String userId,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "3") Integer pageSize) throws ParseException {
        AppResponse resp;

        TPostsPageListVo tPostsPageListVo = new TPostsPageListVo();
        // 计算当前用户收藏的帖子数
        int total = tCollectService.countColPosts(userId);
        tPostsPageListVo.setTotal(total);
        // 远程调用， 获取用户信息
        AppResponse<TUser> response = tUserClient.selectUser(userId);
        if (response.getData() == null){
            resp = AppResponse.fail(null);
            resp.setMsg("获取收藏的帖子失败");
            return resp;
        }
        TUser tUser = response.getData();

        // 页面表示第几次请求，pageSize表示，一次请求几个数据
        List<TPosts> tPostsList =  tPostsService.selectCol(userId,pageNum,pageSize);
        List<TPostsVo> list = new ArrayList<>();
        if (tPostsList == null){
            resp = AppResponse.fail(null);
            resp.setMsg("到底了哦~");
            return resp;
        }
        for (int i = 0; i < tPostsList.size(); i++) {
            // 获取查询的数据
            TPosts tPosts = tPostsList.get(i);
            // 创建返回对象
            TPostsVo tPostsVo = new TPostsVo();
            // 将小vo的对象来对拷到大Vo中，date没拷上
            BeanUtils.copyProperties(tPosts,tPostsVo);
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
            // 收藏、评论、点赞。
            tPostsVo.setColNum(colNum);
            tPostsVo.setComNum(comNum);
            tPostsVo.setLikeNum(likeNum);
            // 是否收藏、评论、点赞了  是1否0
            String isCol = tCollectService.isCollect(tPosts.getPosId(),userId);
            String isCom = tCommentService.isComment(tPosts.getPosId(),userId);
            String isLike = tLikeService.isLike(tPosts.getPosId(),userId);
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
     * 添加帖子到我的收藏
     */
    @GetMapping("/add")
    public AppResponse<Object> add(@RequestParam("userId") String userId, @RequestParam("posId") String posId) throws ParseException {
        AppResponse resp;
        Integer pid = Integer.parseInt(posId);
        Integer uid = Integer.parseInt(userId);

        // 先检查是否添加了。
        String like = tCollectService.isCollect(pid, userId);
        if (like == "1"){
            resp = AppResponse.fail(null);
            resp.setMsg("您已收藏");
            return resp;
        }
        TCollect tCollect = new TCollect();
        tCollect.setPosId(pid);
        tCollect.setUserId(uid);
        tCollect.setCollDate(AppDateUtils.getDateTime());
        int i = tCollectService.addCol(tCollect);
        if (i==1){
            return AppResponse.ok("ok");
        }else {
            resp = AppResponse.fail(null);
            resp.setMsg("收藏失败");
            return resp;
        }
    }



    /**
     * 取消收藏
     */
    @DeleteMapping("/delete/{posId}/{userId}")
    public AppResponse<Object> delete( @PathVariable String posId,@PathVariable String userId){
        AppResponse resp;
        Integer pid = Integer.parseInt(posId);

        // 先检查是否添加了。
        String like = tCollectService.isCollect(pid, userId);
        if (like == "0"){
            resp = AppResponse.fail(null);
            resp.setMsg("您未收藏");
            return resp;
        }

        // 放到Service中去转换类型
        int i = tCollectService.delete(posId,userId);
        if (i == 1){
            resp = AppResponse.ok("ok");
            return resp;
        }else {
            resp = AppResponse.fail(null);
            resp.setMsg("取消收藏失败");
            return resp;
        }
    }


}
