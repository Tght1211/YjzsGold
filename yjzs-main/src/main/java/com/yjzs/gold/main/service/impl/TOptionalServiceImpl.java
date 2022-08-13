package com.yjzs.gold.main.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yjzs.gold.main.bean.*;
import com.yjzs.gold.main.mapper.TFundMapper;
import com.yjzs.gold.main.mapper.TOptionalMapper;
import com.yjzs.gold.main.service.TFundService;
import com.yjzs.gold.main.service.TOptionalService;

import com.yjzs.gold.utils.AppDateUtils;
import com.yjzs.gold.utils.FundUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TOptionalServiceImpl implements TOptionalService {


    @Autowired
    TOptionalMapper tOptionalMapper;


    @Autowired
    TFundService tFundService;

    @Autowired
    TFundMapper tFundMapper;
    /**
     * 查询用户的自选。
     * @param id
     * @return
     */
    @Override
    public List<TOptional> selectMyOpt(Integer id,Integer pageNum,Integer pageSize) {
        // 使用pageHelper实现分页,加这个就可以了
        PageHelper.startPage(pageNum,pageSize);

        TOptionalExample example = new TOptionalExample();
        // 找到用户的自选
        example.createCriteria().andUserIdEqualTo(id);

        List<TOptional> list = tOptionalMapper.selectByExample(example);

        if (list == null){
            return null;
        }else{
            return list;
        }

    }

    /**
     * 添加到自选
     * @param userId
     * @return
     */

    @Override
    public int addMyOpt(String fundCode, String userId) throws Exception {

        Integer uid = Integer.parseInt(userId);

        // 获取基金id，
        TFund tFund = tFundService.selectFundCodeNoLike(fundCode);
        Integer fundId = tFund.getFundId();

        TOptionalExample example = new TOptionalExample();
        example.createCriteria().andUserIdEqualTo(uid).andFundIdEqualTo(fundId);
        List<TOptional> list = tOptionalMapper.selectByExample(example);
        if (list == null || list.size() == 0){
            JSONObject code7Info = FundUtils.getByFundCode_7Info(fundCode);


            TOptional optional = new TOptional();
            optional.setUserId(uid);
            optional.setFundId(fundId);


            // 1.自选时基金交易单位净值，第二天来加。 optPrice

            // 这里的自选指交易日。第二天来加。  optDate     到了交易时间，再判断这些都为null，就可以进行赋值
            // 2.这里先记录，添加时的时间，后面再改
            String formatTime = AppDateUtils.getFormatTime();
            Date date = AppDateUtils.StringToDateDay(formatTime);
            optional.setOptDate(date);

            // 3.添加自选后的收益，从第二个交易日开始，来计算 后面的净值减去添加自选当天的净值，    optProfitProp

            int i = tOptionalMapper.insertSelective(optional);

            if (i != 0){
                return 1;
            }else {
                return 0;
            }
        }else {
            return 2;
        }
    }

    /**
     * 从自选中移除
     * @param fundCode
     * @param userId
     * @return
     */
    @Override
    public int deleteMy(String fundCode, String userId) {
        // 用户id转换类型
        Integer uid = Integer.parseInt(userId);
        // 获取基金id，
        TFund tFund = tFundService.selectFundCodeNoLike(fundCode);
        Integer fundId = tFund.getFundId();

        TOptionalExample example = new TOptionalExample();
        example.createCriteria().andFundIdEqualTo(fundId).andUserIdEqualTo(uid);

        int i = tOptionalMapper.deleteByExample(example);

        if (i != 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String isZhiX(String fundCode, Integer id) {
        //根据基金代码找基金id
        TFundExample example1 = new TFundExample();
        example1.createCriteria().andFundCodeEqualTo(fundCode);
        List<TFund> list = tFundMapper.selectByExample(example1);
        TFund tFund = list.get(0);
        Integer fundId = tFund.getFundId();
        //匹配基金和用户是否持有
        TOptionalExample example2 = new TOptionalExample();
        example2.createCriteria().andFundIdEqualTo(fundId).andUserIdEqualTo(id);
        List<TOptional> tOptionals = tOptionalMapper.selectByExample(example2);
        if (tOptionals == null || tOptionals.size()==0){
            return "0";
        }else {
            return "1";
        }
    }

    @Override
    public int countOptbyUserId(Integer id) {

        TOptionalExample example = new TOptionalExample();
        // 找到用户的自选
        example.createCriteria().andUserIdEqualTo(id);

        List<TOptional> list = tOptionalMapper.selectByExample(example);

        if (list == null){
            return 0;
        }else{
            return list.size();
        }
    }
}
