package com.yjzs.gold.com.vo.resp;

import lombok.Data;

import java.util.List;

/**
 * @author Tght
 */
@Data
public class TComPageListVo {
    private List<TComVo> records;
    /**
     * 主评论数量
     */
    private int total;
}
