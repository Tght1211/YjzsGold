package com.yjzs.gold.com.mapper;

import com.yjzs.gold.com.bean.TFollow;
import com.yjzs.gold.com.bean.TFollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TFollowMapper {
    long countByExample(TFollowExample example);

    int deleteByExample(TFollowExample example);

    int insert(TFollow record);

    int insertSelective(TFollow record);

    List<TFollow> selectByExample(TFollowExample example);

    int updateByExampleSelective(@Param("record") TFollow record, @Param("example") TFollowExample example);

    int updateByExample(@Param("record") TFollow record, @Param("example") TFollowExample example);
}