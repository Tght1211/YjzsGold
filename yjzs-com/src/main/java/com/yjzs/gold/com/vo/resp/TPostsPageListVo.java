package com.yjzs.gold.com.vo.resp;

import lombok.Data;

import java.util.List;

/**
 * @author Tght
 */
@Data
public class TPostsPageListVo {

    private List<TPostsVo> records;

    private int total;
}
