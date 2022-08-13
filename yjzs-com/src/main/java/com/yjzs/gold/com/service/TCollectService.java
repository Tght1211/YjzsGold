package com.yjzs.gold.com.service;

import com.yjzs.gold.com.bean.TCollect;

public interface TCollectService {
    int selectNum(Integer posId);

    String isCollect(Integer posId, String userId);

    int addCol(TCollect tCollect);

    int delete(String posId, String userId);

    int countColPosts(String userId);
}
