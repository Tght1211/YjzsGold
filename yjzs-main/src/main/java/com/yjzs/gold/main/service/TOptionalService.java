package com.yjzs.gold.main.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjzs.gold.main.bean.TOptional;

import java.util.List;

public interface TOptionalService extends IService<TOptional> {

    List<TOptional> selectMyOpt(Integer id, Integer pageNum, Integer pageSize);

    int addMyOpt(String fundCode, String userId) throws Exception;

    int deleteMy(String fundCode, String userId);

    String isZhiX(String fundCode, Integer id);

    int countOptbyUserId(Integer id);
}
