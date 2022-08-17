package com.yjzs.gold.com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjzs.gold.com.bean.TComment;
import com.yjzs.gold.com.bean.TCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TCommentMapper extends BaseMapper<TComment> {
    long countByExample(TCommentExample example);

    int deleteByExample(TCommentExample example);

    int insert(TComment record);

    int insertSelective(TComment record);

    List<TComment> selectByExample(TCommentExample example);

    int updateByExampleSelective(@Param("record") TComment record, @Param("example") TCommentExample example);

    int updateByExample(@Param("record") TComment record, @Param("example") TCommentExample example);
}