package com.yjzs.gold.com.service;

import com.yjzs.gold.com.bean.TLike;

public interface TLikeService {
    String isLike(Integer posId, String userId);

    int addLike(TLike tLike);

    int delete(String posId, String userId);

    int selectNum(Integer posId);
}
