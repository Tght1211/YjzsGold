package com.yjzs.gold.main.vo.resp;

import lombok.Data;

import java.util.List;

/**
 * @author Tght
 */
@Data
public class FundPageListVo {

    private List<FundVo> records;

    private int total;
}
