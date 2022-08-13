package com.yjzs.gold.main.mapper;

import com.yjzs.gold.main.bean.TOperation;
import com.yjzs.gold.main.bean.TOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TOperationMapper {
    long countByExample(TOperationExample example);

    int deleteByExample(TOperationExample example);

    int insert(TOperation record);

    int insertSelective(TOperation record);

    List<TOperation> selectByExample(TOperationExample example);

    int updateByExampleSelective(@Param("record") TOperation record, @Param("example") TOperationExample example);

    int updateByExample(@Param("record") TOperation record, @Param("example") TOperationExample example);
}