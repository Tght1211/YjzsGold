package com.yjzs.gold.com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjzs.gold.com.bean.*;
import com.yjzs.gold.com.mapper.TCollectMapper;
import com.yjzs.gold.com.service.TCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TCollectServiceImpl extends ServiceImpl<TCollectMapper,TCollect> implements TCollectService {
    @Autowired
    TCollectMapper tCollectMapper;

    /**
     * 找到该帖子下收藏的数量
     * @param posId
     * @return
     */
    @Override
    public int selectNum(Integer posId) {

        TCollectExample example = new TCollectExample();
        // 找到该帖子下的用户收藏数量
        example.createCriteria().andPosIdEqualTo(posId);

        List<TCollect> list = tCollectMapper.selectByExample(example);

        if (list == null){
            return 0;
        }else{
            return list.size();
        }

    }

    /**
     * 查看当前用户是否收藏了
     * @param posId
     * @param userId
     * @return
     */
    @Override
    public String isCollect(Integer posId, String userId) {

        Integer id = Integer.parseInt(userId);

        TCollectExample example = new TCollectExample();
        // 找到用户的自选
        example.createCriteria().andUserIdEqualTo(id).andPosIdEqualTo(posId);

        List<TCollect> list = tCollectMapper.selectByExample(example);

        if (list == null || list.size() == 0){
            return "0";
        }else{
            return "1";
        }
    }

    /**
     * 添加帖子到收藏
     * @param tCollect
     * @return
     */
    @Override
    public int addCol(TCollect tCollect) {
        try {
            int i = tCollectMapper.insertSelective(tCollect);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 取消帖子收藏
     * @param posId
     * @param userId
     * @return
     */
    @Override
    public int delete(String posId, String userId) {
        // 用户id转换类型
        Integer uid = Integer.parseInt(userId);
        Integer pid = Integer.parseInt(posId);

        TCollectExample example = new TCollectExample();
        example.createCriteria().andUserIdEqualTo(uid).andPosIdEqualTo(pid);

        int i = tCollectMapper.deleteByExample(example);

        if (i != 0){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 计算收藏的帖子数
     * @param userId
     * @return
     */
    @Override
    public int countColPosts(String userId) {
        TCollectExample example = new TCollectExample();
        // 找到用户的自选
        Integer id = Integer.parseInt(userId);
        example.createCriteria().andUserIdEqualTo(id);

        List<TCollect> list = tCollectMapper.selectByExample(example);

        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }
}
