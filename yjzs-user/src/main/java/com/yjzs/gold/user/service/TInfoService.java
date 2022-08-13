package com.yjzs.gold.user.service;

import com.yjzs.gold.user.bean.TInfo;

/**
 * @author Tght
 */
public interface TInfoService {
    TInfo getInfobyUserId(Integer id);

    int saveInfo(TInfo info);

    int updateInfo(TInfo tInfo);
}
