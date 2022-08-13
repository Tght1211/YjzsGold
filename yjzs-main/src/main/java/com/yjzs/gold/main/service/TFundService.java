package com.yjzs.gold.main.service;

import com.yjzs.gold.main.bean.TFund;

import java.util.List;

/**
 * @author Tght
 */
public interface TFundService {
    List<TFund> selectFundCode(String fundCode,Integer pageNum,Integer pageSize);

    int addFundCode(String fundCode);

    List<TFund> selectFund(Integer pageNum,Integer pageSize);


    TFund selectFundById(Integer fundId);

    List<TFund> selectFundByName(String fundName,Integer pageNum,Integer pageSize);

    TFund selectFundCodeNoLike(String fundCode);

    int countFund();

    int countFundByName(String fundName);

    int countFundByCode(String fundCode);
}
