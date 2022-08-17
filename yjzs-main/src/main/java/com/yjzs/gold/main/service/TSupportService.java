package com.yjzs.gold.main.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjzs.gold.main.bean.TSupport;

public interface TSupportService extends IService<TSupport> {
    String isChiY(String fundCode, Integer id);

    int selectNum(String fundCode);
}
