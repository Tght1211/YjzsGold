package com.yjzs.gold.com.service.impl;

import com.github.pagehelper.PageHelper;
import com.yjzs.gold.com.bean.*;
import com.yjzs.gold.com.mapper.TCollectMapper;
import com.yjzs.gold.com.mapper.TCommentMapper;
import com.yjzs.gold.com.service.TCollectService;
import com.yjzs.gold.com.service.TCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TCommentServiceImpl implements TCommentService {
    @Autowired
    TCommentMapper tCommentMapper;

    /**
     * 找到该帖子下评论的数量
     *
     * @param posId
     * @return
     */
    @Override
    public int selectNum(Integer posId) {
        TCommentExample example = new TCommentExample();
        // 找到该帖子的评论数
        example.createCriteria().andPosIdEqualTo(posId);

        List<TComment> list = tCommentMapper.selectByExample(example);

        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    /**
     * 当前用户是否评论了该帖子
     *
     * @param posId
     * @param userId
     * @return
     */
    @Override
    public String isComment(Integer posId, String userId) {
        Integer id = Integer.parseInt(userId);

        TCommentExample example = new TCommentExample();
        // 找到该帖子的评论数
        example.createCriteria().andPosIdEqualTo(posId).andUserIdEqualTo(id);

        List<TComment> list = tCommentMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            return "0";
        } else {
            return "1";
        }
    }


    /**
     * 查看主评论内容
     * 时间排序
     *
     * @param postId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TComment> selectComs(String postId, Integer pageNum, Integer pageSize) {
        // 使用pageHelper实现分页,加这个就可以了
        PageHelper.startPage(pageNum, pageSize);

        TCommentExample example = new TCommentExample();
        Integer id = Integer.parseInt(postId);
        // 帖子id 对应的评论帖子，类型为评论帖子
        // 自己写，自己来order by，降序
        example.setOrderByClause("com_date desc");
        example.createCriteria().andPosIdEqualTo(id).andComTypeEqualTo("0");

        List<TComment> tComments = tCommentMapper.selectByExample(example);
        if (tComments.size() == 0) {
            return null;
        } else {
            return tComments;
        }
    }

    /**
     * 查询该评论下有几条子评论
     *
     * @param comId
     * @return
     */
    @Override
    public int zCountComs(Integer comId) {

        TCommentExample example = new TCommentExample();
        // 关联到主评论id
        example.createCriteria().andComConIdEqualTo(comId);

        List<TComment> tComments = tCommentMapper.selectByExample(example);
        if (tComments.size() == 0) {
            return 0;
        } else {
            return tComments.size();
        }
    }

    /**
     * 分页查看子评论内容
     * 最新排序
     *
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TComment> selectComsZ(Integer id, Integer pageNum, Integer pageSize) {
        // 使用pageHelper实现分页,加这个就可以了
        PageHelper.startPage(pageNum, pageSize);

        TCommentExample example = new TCommentExample();
        // 帖子id 对应的评论帖子，类型为评论帖子
        // 自己写，自己来order by，降序
        example.setOrderByClause("com_date desc");
        // 只要关联id为主评论id就行。
        example.createCriteria().andComConIdEqualTo(id);

        List<TComment> tComments = tCommentMapper.selectByExample(example);
        if (tComments.size() == 0) {
            return null;
        } else {
            return tComments;
        }
    }

    @Override
    public int insertCom(TComment tComment) {
        try {
            int i = tCommentMapper.insertSelective(tComment);
            System.out.println(i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String isExit(Integer cid) {

        TCommentExample example = new TCommentExample();
        // 找到用户的自选
        example.createCriteria().andComIdEqualTo(cid);

        List<TComment> list = tCommentMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            return "0";
        } else {
            return "1";
        }
    }

    @Override
    public int delete(String comId) {

        Integer cid = Integer.parseInt(comId);
        TCommentExample example = new TCommentExample();
        example.createCriteria().andComIdEqualTo(cid);

        List<TComment> list = tCommentMapper.selectByExample(example);
        TComment tComment = list.get(0);
        int i = 0;
        if (tComment.getComType() == "0") {
            // 1.先看这个评论的类型。主评论 | 子评论  | 3类型
            // 找出以这个id为con关联id的帖子都删除，最后删主评论
            TCommentExample example1 = new TCommentExample();
            example.createCriteria().andComConIdEqualTo(cid);
            i = tCommentMapper.deleteByExample(example);
        } else if (tComment.getComType() == "1") {
            // 2. 主评论被删，子评论和3类型一起删除。
            // 子评论删除，找出3评论，只要类型中包含cid的就删除。
            TCommentExample example1 = new TCommentExample();
            example.createCriteria().andComTypeLike(cid+"@"+'%');
            i = tCommentMapper.deleteByExample(example);
        }

        // 3. 子评论删除，3类型也一起删除。
        i = tCommentMapper.deleteByExample(example);

        if (i != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int selectNumZ(Integer id) {
        TCommentExample example = new TCommentExample();
        // 找到该帖子的评论数
        example.createCriteria().andPosIdEqualTo(id).andComTypeEqualTo("0");

        List<TComment> list = tCommentMapper.selectByExample(example);

        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }
}
