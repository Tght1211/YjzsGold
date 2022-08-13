package com.yjzs.gold.main.service.impl;

import com.yjzs.gold.main.bean.TFund;
import com.yjzs.gold.main.bean.TFundExample;
import com.yjzs.gold.main.bean.TSupport;
import com.yjzs.gold.main.bean.TSupportExample;
import com.yjzs.gold.main.mapper.TFundMapper;
import com.yjzs.gold.main.mapper.TSupportMapper;
import com.yjzs.gold.main.service.TSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tght
 */
@Service
public class TSupportServiceImpl implements TSupportService {

    @Autowired
    TFundMapper tFundMapper;

    @Autowired
    TSupportMapper tSupportMapper;

    @Override
    public String isChiY(String fundCode, Integer id) {

        //根据基金代码找基金id
        TFundExample example1 = new TFundExample();
        example1.createCriteria().andFundCodeEqualTo(fundCode);
        List<TFund> list = tFundMapper.selectByExample(example1);
        TFund tFund = list.get(0);
        Integer fundId = tFund.getFundId();
        //匹配基金和用户是否持有
        TSupportExample example2 = new TSupportExample();
        example2.createCriteria().andFundIdEqualTo(fundId).andUserIdEqualTo(id);
        List<TSupport> tSupports = tSupportMapper.selectByExample(example2);
        if (tSupports == null || tSupports.size()==0){
            return "0";
        }else {
            return "1";
        }
    }

    /**
     * 计算当前基的持有人数。
     * @param fundCode
     * @return
     */
    @Override
    public int selectNum(String fundCode) {
        //根据基金代码找基金id
        TFundExample example1 = new TFundExample();
        example1.createCriteria().andFundCodeEqualTo(fundCode);
        List<TFund> list = tFundMapper.selectByExample(example1);
        TFund tFund = list.get(0);
        Integer fundId = tFund.getFundId();
        //计算人数
        TSupportExample example2 = new TSupportExample();
        example2.createCriteria().andFundIdEqualTo(fundId);
        List<TSupport> tSupports = tSupportMapper.selectByExample(example2);
        int size = tSupports.size();
        return size;
    }
}
