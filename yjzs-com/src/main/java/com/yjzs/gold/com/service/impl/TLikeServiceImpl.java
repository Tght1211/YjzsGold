package com.yjzs.gold.com.service.impl;

import com.yjzs.gold.com.bean.TLike;
import com.yjzs.gold.com.bean.TLikeExample;
import com.yjzs.gold.com.mapper.TLikeMapper;
import com.yjzs.gold.com.service.TLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TLikeServiceImpl implements TLikeService {

    @Autowired
    TLikeMapper tLikeMapper;

    /**
     * 是否操作了点赞
     * @param posId
     * @param userId
     * @return
     */
    @Override
    public String isLike(Integer posId, String userId) {
        Integer id = Integer.parseInt(userId);

        TLikeExample example = new TLikeExample();
        // 找到用户的自选
        example.createCriteria().andUserIdEqualTo(id).andPosIdEqualTo(posId);

        List<TLike> list = tLikeMapper.selectByExample(example);

        if (list == null || list.size() == 0){
            return "0";
        }else{
            return "1";
        }
    }

    /**
     * 找到该帖子下点赞的数量
     * @param posId
     * @return
     */
    @Override
    public int selectNum(Integer posId) {
        TLikeExample example = new TLikeExample();
        // 找到该帖子的评论数
        example.createCriteria().andPosIdEqualTo(posId);

        List<TLike> list = tLikeMapper.selectByExample(example);

        if (list == null || list.size() == 0){
            return 0;
        }else{
            return list.size();
        }
    }

    /**
     * 点赞
     * @param tLike
     * @return
     */
    @Override
    public int addLike(TLike tLike) {

        try {
            int i = tLikeMapper.insertSelective(tLike);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 取消点赞
     * @param posId
     * @param userId
     * @return
     */
    @Override
    public int delete(String posId, String userId) {
        // 用户id转换类型
        Integer uid = Integer.parseInt(userId);
        Integer pid = Integer.parseInt(posId);

        TLikeExample example = new TLikeExample();
        example.createCriteria().andUserIdEqualTo(uid).andPosIdEqualTo(pid);

        int i = tLikeMapper.deleteByExample(example);

        if (i != 0){
            return 1;
        }else {
            return 0;
        }
    }
}
