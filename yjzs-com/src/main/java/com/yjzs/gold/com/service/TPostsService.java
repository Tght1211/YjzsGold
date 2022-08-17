package com.yjzs.gold.com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjzs.gold.com.bean.TPosts;

import java.util.List;

public interface TPostsService extends IService<TPosts> {
    int insertPost(TPosts tPosts);

    List<TPosts> selectMy(String userId, Integer pageNum, Integer pageSize);

    int countMyPosts(String userId);

    List<TPosts> selectMy(String userId);


    List<TPosts> selectCol(String userId, Integer pageNum, Integer pageSize);

    int update(TPosts tPosts);

    int countPosts();

    List<TPosts> selectNew(Integer pageNum, Integer pageSize);

    int delete(Integer cid);
}
