package com.yjzs.gold.com.mapper;

import com.yjzs.gold.com.bean.TPosts;
import com.yjzs.gold.com.bean.TPostsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Repository Spring提供的注解
 * @Mapper mybatis提供的注解
 */
@Repository
//@Mapper
public interface TPostsMapper {
    long countByExample(TPostsExample example);

    int deleteByExample(TPostsExample example);

    int insert(TPosts record);

    int insertSelective(TPosts record);

    List<TPosts> selectByExample(TPostsExample example);

    int updateByExampleSelective(@Param("record") TPosts record, @Param("example") TPostsExample example);

    int updateByExample(@Param("record") TPosts record, @Param("example") TPostsExample example);

    /**查出用户的所有帖子。然后安装时间排序
     *  降序 desc
     *  升序 asc  (默认)
     * @param id
     * @return
     */
    //@Select("select * form t_posts where user_id=#{id} order by posDate desc")
   // List<TPosts> selectByExampleEditor(Integer id);
}