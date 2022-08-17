package com.yjzs.gold.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjzs.gold.main.bean.TOptional;
import com.yjzs.gold.main.bean.TOptionalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper

public interface TOptionalMapper extends BaseMapper<TOptional> {
    long countByExample(TOptionalExample example);

    int deleteByExample(TOptionalExample example);

    int insert(TOptional record);

    int insertSelective(TOptional record);

    List<TOptional> selectByExample(TOptionalExample example);

    int updateByExampleSelective(@Param("record") TOptional record, @Param("example") TOptionalExample example);

    int updateByExample(@Param("record") TOptional record, @Param("example") TOptionalExample example);
}