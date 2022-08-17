package com.yjzs.gold.com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjzs.gold.com.bean.TLike;
import com.yjzs.gold.com.bean.TLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TLikeMapper extends BaseMapper<TLike> {
    long countByExample(TLikeExample example);

    int deleteByExample(TLikeExample example);

    int insert(TLike record);

    int insertSelective(TLike record);

    List<TLike> selectByExample(TLikeExample example);

    int updateByExampleSelective(@Param("record") TLike record, @Param("example") TLikeExample example);

    int updateByExample(@Param("record") TLike record, @Param("example") TLikeExample example);
}