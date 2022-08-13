package com.yjzs.gold.com.mapper;

import com.yjzs.gold.com.bean.TCollect;
import com.yjzs.gold.com.bean.TCollectExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TCollectMapper {
    long countByExample(TCollectExample example);

    int deleteByExample(TCollectExample example);

    int insert(TCollect record);

    int insertSelective(TCollect record);

    List<TCollect> selectByExample(TCollectExample example);

    int updateByExampleSelective(@Param("record") TCollect record, @Param("example") TCollectExample example);

    int updateByExample(@Param("record") TCollect record, @Param("example") TCollectExample example);
}