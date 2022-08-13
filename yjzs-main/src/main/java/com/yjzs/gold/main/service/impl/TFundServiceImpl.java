package com.yjzs.gold.main.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yjzs.gold.main.bean.TFund;
import com.yjzs.gold.main.bean.TFundExample;
import com.yjzs.gold.main.mapper.TFundMapper;
import com.yjzs.gold.main.service.TFundService;
import com.yjzs.gold.utils.FundUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tght
 */
@Service
public class TFundServiceImpl implements TFundService {

    @Autowired
    TFundMapper tFundMapper;

    /**
     * 根据基金代码查找基金类,like
     * @param fundCode
     * @return
     */
    @Override
    public List<TFund> selectFundCode(String fundCode,Integer pageNum,Integer pageSize) {
        // 使用pageHelper实现分页,加这个就可以了
        PageHelper.startPage(pageNum,pageSize);
        // select * (你的sql) limit 1,10；


        TFundExample example = new TFundExample();
        // 找到基金代码,状态给前端鉴别，增加接口复用性
        example.createCriteria().andFundCodeLike('%'+fundCode+'%');

        List<TFund> list;
        try {
            list = tFundMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (list == null || list.size() == 0) {
             return null;
        } else {
            return list;
        }

    }

    @Override
    public int addFundCode(String fundCode) {

        try {
            JSONObject code7Info = FundUtils.getByFundCode_7Info(fundCode);
            TFund tFund = new TFund();
            tFund.setFundCode(fundCode);
            tFund.setFundName(code7Info.getString("name"));
            //  （0为正常，1为删除状态，2为待确认状态[这个状态取消]）
            tFund.setFundStatus("0");

            int i = tFundMapper.insertSelective(tFund);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 列出所有基金，不用排序,但是限制要是为0状态的正常基金
     * 分页限制,使用分页插件.
     * @return
     */
    @Override
    public List<TFund> selectFund(Integer pageNum,Integer pageSize) {
        // 使用pageHelper实现分页
        PageHelper.startPage(pageNum,pageSize);

        TFundExample example = new TFundExample();
        // 找到基金代码，状态给前端鉴别
        example.createCriteria();
        List<TFund> list = tFundMapper.selectByExample(example);

        /*PageInfo<TFund> listPage = new PageInfo<>(list);
        // 获取分页后的数据
        List<TFund> listPageList = listPage.getList();*/

        if (list.size() == 0) {
            return null;
        } else {
          // list.get(0);获取集合中的0号元素
            return list;
        }
    }

    @Override


    public TFund selectFundById(Integer fundId) {
        TFundExample example = new TFundExample();
        // 找到基金代码，状态给前端鉴别
        example.createCriteria().andFundIdEqualTo(fundId);

        List<TFund> list = tFundMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            return null;
        } else {
            // list.get(0);获取集合中的0号元素
            return list.get(0);
        }
    }

    /**
     * 模糊查看进名字 ,记得来指定%%
     * @param fundName
     * @return
     */
    @Override
    public List<TFund> selectFundByName(String fundName,Integer pageNum,Integer pageSize) {

        // 使用pageHelper实现分页,加这个就可以了
        PageHelper.startPage(pageNum,pageSize);

        TFundExample example = new TFundExample();
        // 找到基金代码，状态给前端鉴别
        // 模糊查询,记得来指定%%
        example.createCriteria().andFundNameLike('%'+fundName+'%');

        List<TFund> list = tFundMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            return null;
        } else {
            // list.get(0);获取集合中的0号元素
            return list;
        }
    }

    @Override
    public TFund selectFundCodeNoLike(String fundCode) {
        TFundExample example = new TFundExample();
        // 找到基金代码,状态给前端鉴别，增加接口复用性
        example.createCriteria().andFundCodeEqualTo(fundCode);

        List<TFund> list;
        try {
            list = tFundMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }

    }

    /**
     * 计算基金total
     * @return
     */
    @Override
    public int countFund() {
        TFundExample example = new TFundExample();
        // 找到基金代码，状态给前端鉴别
        example.createCriteria();
        List<TFund> list = tFundMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            return 0;
        } else {
            return list.size();
        }
    }

    @Override
    public int countFundByName(String fundName) {
        TFundExample example = new TFundExample();
        // 找到基金代码，状态给前端鉴别
        example.createCriteria().andFundNameLike('%'+fundName+'%');
        List<TFund> list = tFundMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            return 0;
        } else {
            return list.size();
        }
    }

    @Override
    public int countFundByCode(String fundCode) {
        TFundExample example = new TFundExample();
        // 找到基金代码，状态给前端鉴别
        example.createCriteria().andFundCodeLike('%'+fundCode+'%');
        List<TFund> list = tFundMapper.selectByExample(example);

        if (list == null || list.size() == 0) {
            return 0;
        } else {
            return list.size();
        }
    }

}
