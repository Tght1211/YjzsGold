package com.yjzs.gold.main.mapper;

import com.yjzs.gold.main.bean.TFund;
import com.yjzs.gold.main.bean.TFundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TFundMapper {
    long countByExample(TFundExample example);

    int deleteByExample(TFundExample example);

    int insert(TFund record);

    int insertSelective(TFund record);

    List<TFund> selectByExample(TFundExample example);

    int updateByExampleSelective(@Param("record") TFund record, @Param("example") TFundExample example);

    int updateByExample(@Param("record") TFund record, @Param("example") TFundExample example);
}