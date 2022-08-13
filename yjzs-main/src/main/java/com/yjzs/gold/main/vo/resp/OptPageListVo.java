package com.yjzs.gold.main.vo.resp;

import lombok.Data;

import java.util.List;

/**
 * @author Tght
 */
@Data
public class OptPageListVo {

    private List<OptVo> records;

    private int total;
}
