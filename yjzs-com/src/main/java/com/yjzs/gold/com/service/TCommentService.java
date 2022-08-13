package com.yjzs.gold.com.service;

import com.yjzs.gold.com.bean.TComment;
import com.yjzs.gold.com.bean.TPosts;

import java.util.List;

public interface TCommentService {
    int selectNum(Integer posId);

    String isComment(Integer posId, String userId);


    List<TComment> selectComs(String postId, Integer pageNum, Integer pageSize);

    int zCountComs(Integer comId);

    List<TComment> selectComsZ(Integer id, Integer pageNum, Integer pageSize);

    int insertCom(TComment tComment);

    String isExit(Integer cid);

    int delete(String comId);

    int selectNumZ(Integer id);
}
