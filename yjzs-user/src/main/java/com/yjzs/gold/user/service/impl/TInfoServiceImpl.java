package com.yjzs.gold.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjzs.gold.user.bean.TInfo;
import com.yjzs.gold.user.mapper.TInfoMapper;
import com.yjzs.gold.user.service.TInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Tght
 */
@Slf4j
@Service
public class TInfoServiceImpl extends ServiceImpl<TInfoMapper,TInfo> implements TInfoService {

    @Override
    public TInfo getInfobyUserId(Integer id) {
        return null;
    }

    @Override
    public int saveInfo(TInfo info) {
        return 0;
    }

    @Override
    public int updateInfo(TInfo tInfo) {
        return 0;
    }
}
