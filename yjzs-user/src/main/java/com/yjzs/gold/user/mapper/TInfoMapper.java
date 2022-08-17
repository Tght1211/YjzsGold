package com.yjzs.gold.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjzs.gold.user.bean.TInfo;
import com.yjzs.gold.user.bean.TInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TInfoMapper extends BaseMapper<TInfo>{
    long countByExample(TInfoExample example);

    int deleteByExample(TInfoExample example);

    int insert(TInfo record);

//    int insertSelective(TInfo record);

    List<TInfo> selectByExample(TInfoExample example);

    int updateByExampleSelective(@Param("record") TInfo record, @Param("example") TInfoExample example);

    int updateByExample(@Param("record") TInfo record, @Param("example") TInfoExample example);
}