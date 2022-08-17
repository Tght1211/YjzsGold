package com.yjzs.gold.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjzs.gold.main.bean.TSupport;
import com.yjzs.gold.main.bean.TSupportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TSupportMapper extends BaseMapper<TSupport> {
    long countByExample(TSupportExample example);

    int deleteByExample(TSupportExample example);

    int insert(TSupport record);

    int insertSelective(TSupport record);

    List<TSupport> selectByExample(TSupportExample example);

    int updateByExampleSelective(@Param("record") TSupport record, @Param("example") TSupportExample example);

    int updateByExample(@Param("record") TSupport record, @Param("example") TSupportExample example);
}