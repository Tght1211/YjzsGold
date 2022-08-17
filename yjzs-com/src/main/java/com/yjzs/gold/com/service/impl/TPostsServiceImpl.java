package com.yjzs.gold.com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.yjzs.gold.com.bean.TCollect;
import com.yjzs.gold.com.bean.TCollectExample;
import com.yjzs.gold.com.bean.TPosts;
import com.yjzs.gold.com.bean.TPostsExample;
import com.yjzs.gold.com.mapper.TCollectMapper;
import com.yjzs.gold.com.mapper.TPostsMapper;
import com.yjzs.gold.com.service.TPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tght
 */
@Service
public class TPostsServiceImpl extends ServiceImpl<TPostsMapper,TPosts> implements TPostsService {

    @Autowired
    TPostsMapper tPostsMapper;
    @Autowired
    TCollectMapper tCollectMapper;
    /**
     * 发布我的帖子
     * @param tPosts
     * @return
     */
    @Override
    public int insertPost(TPosts tPosts) {

        try {
            int i = tPostsMapper.insertSelective(tPosts);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 分页查询，实现无限滚动，
     * 查询我的帖子，安装最新的数据先展示的排序
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TPosts> selectMy(String userId, Integer pageNum, Integer pageSize) {
        // 使用pageHelper实现分页,加这个就可以了
        PageHelper.startPage(pageNum, pageSize);

        TPostsExample example = new TPostsExample();
        // 找到用户的自选
        Integer id = Integer.parseInt(userId);
        example.setOrderByClause("pos_date desc");
        example.createCriteria().andUserIdEqualTo(id).andPosStatusEqualTo("0");
      //  List<TPosts> list = tPostsMapper.selectByExample(example);
        // 全部查出来。
        List<TPosts> list = tPostsMapper.selectByExample(example);

        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * 计算我的帖子的数量
     * @param userId
     * @return
     */
    @Override
    public int countMyPosts(String userId) {

        TPostsExample example = new TPostsExample();
        // 找到用户的自选
        Integer id = Integer.parseInt(userId);
        example.createCriteria().andUserIdEqualTo(id).andPosStatusEqualTo("0");

        List<TPosts> list = tPostsMapper.selectByExample(example);

        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    /**
     * 查看四个信息，日期、标题、帖子类型、帖子热度
     * 全部查出来
     * @param userId
     * @return
     */
    @Override
    public List<TPosts> selectMy(String userId) {
        TPostsExample example = new TPostsExample();
        // 找到用户的自选
        Integer id = Integer.parseInt(userId);
        // 自己写，自己来order by
        example.setOrderByClause("pos_date desc");
        example.createCriteria().andUserIdEqualTo(id).andPosStatusEqualTo("0");

        List<TPosts> list = tPostsMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * 查看用户收藏的帖子，有分页
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TPosts> selectCol(String userId, Integer pageNum, Integer pageSize) {
        // 使用pageHelper实现分页,加这个就可以了
        PageHelper.startPage(pageNum, pageSize);

        Integer id = Integer.parseInt(userId);
        // 1找出收藏的帖子id，再去找收藏的帖子
        TCollectExample example1 = new TCollectExample();
        example1.setOrderByClause("coll_id desc");
        example1.createCriteria().andUserIdEqualTo(id);
        // 查看用户的收藏列表
        List<TCollect> tCollects = tCollectMapper.selectByExample(example1);
        // 需要先new出来
        List<TPosts> list1 = new ArrayList<>();
        for (int i = 0; i < tCollects.size(); i++) {
            TCollect tCollect = tCollects.get(i);
            Integer posId = tCollect.getPosId();

            TPostsExample example2 = new TPostsExample();
            example2.createCriteria().andPosIdEqualTo(posId).andPosStatusEqualTo("0");
            // 找出帖子id对应的帖子信息，再放入集合中。
            List<TPosts> list2 = tPostsMapper.selectByExample(example2);
            if (list2.size() == 0){
                // 就取消这个收藏
                TCollectExample example3 = new TCollectExample();
                example3.createCriteria().andPosIdEqualTo(posId);
                int i1 = tCollectMapper.deleteByExample(example3);
                if (i != 0) {
                    // 正确就正常下一步
                } else {
                    return null;
                }
            }else {
                list1.add(list2.get(0));
            }
        }

        if (list1.size() == 0) {
            return null;
        } else {
            return list1;
        }
    }

    /**
     * 更新热度
     * @param tPosts
     * @return
     */
    @Override
    public int update(TPosts tPosts) {

        TPostsExample example = new TPostsExample();
        example.createCriteria().andPosIdEqualTo(tPosts.getPosId());

        int i = tPostsMapper.updateByExampleSelective(tPosts, example);
        return i;
    }

    /**
     * 总帖子数
     * @return
     */
    @Override
    public int countPosts() {
        TPostsExample example = new TPostsExample();
        example.createCriteria().andPosStatusEqualTo("0").andPosTypeEqualTo("0");

        List<TPosts> list = tPostsMapper.selectByExample(example);

        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    /**
     * 最新排序总帖子
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TPosts> selectNew(Integer pageNum, Integer pageSize) {
        // 使用pageHelper实现分页,加这个就可以了
        PageHelper.startPage(pageNum, pageSize);


        TPostsExample example = new TPostsExample();
        // 自己写，自己来order by
        example.setOrderByClause("pos_date desc");
        // 正常存在且公开
        example.createCriteria().andPosStatusEqualTo("0").andPosTypeEqualTo("0");

        List<TPosts> list = tPostsMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * 删除帖子（软删除）
     * @param cid
     * @return
     */
    @Override
    public int delete(Integer cid) {
        TPostsExample example = new TPostsExample();
        example.createCriteria().andPosIdEqualTo(cid);
        List<TPosts> tPosts = tPostsMapper.selectByExample(example);
        TPosts tPosts1 = tPosts.get(0);
        tPosts1.setPosStatus("1");

        int i = tPostsMapper.updateByExampleSelective(tPosts1,example);

        if (i != 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
