package com.yjzs.gold.com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjzs.gold.com.bean.TLike;

public interface TLikeService extends IService<TLike> {
    String isLike(Integer posId, String userId);

    int addLike(TLike tLike);

    int delete(String posId, String userId);

    int selectNum(Integer posId);
}
