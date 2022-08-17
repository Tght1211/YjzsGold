package com.yjzs.gold.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjzs.gold.user.bean.TInfo;

/**
 * @author Tght
 */
public interface TInfoService extends IService<TInfo> {
    TInfo getInfobyUserId(Integer id);

    int saveInfo(TInfo info);

    int updateInfo(TInfo tInfo);
}
