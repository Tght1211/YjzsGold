package com.yjzs.gold.main.controller;


import com.alibaba.fastjson.JSONObject;
import com.yjzs.gold.main.bean.TFund;
import com.yjzs.gold.main.bean.TOptional;
import com.yjzs.gold.main.service.TFundService;
import com.yjzs.gold.main.service.TOptionalService;
import com.yjzs.gold.main.service.TSupportService;
import com.yjzs.gold.main.vo.resp.OptPageListVo;
import com.yjzs.gold.main.vo.resp.OptVo;
import com.yjzs.gold.utils.AppDateUtils;
import com.yjzs.gold.utils.AppResponse;
import com.yjzs.gold.utils.FundUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Tght
 * @RefreshScope 配置自动刷新
 * 这个接口不需要远程调用yjzs_user服务
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/main/optional")
public class OptionalController {

    @Autowired
    TFundService tFundService;

    @Autowired
    TOptionalService tOptionalService;

    @Autowired
    TSupportService tSupportService;

    /**
     * 去养基表查看，当前用户，是否持有该基金
     * @param fundCode
     * @param userId
     * @return
     */
    public String isChiY(String fundCode,String userId){
        Integer id = Integer.parseInt(userId);
        String chiY = tSupportService.isChiY(fundCode,id);
        return chiY;
    }

    public String isZhiX(String fundCode,String userId){
        Integer id = Integer.parseInt(userId);
        String zhiX = tOptionalService.isZhiX(fundCode,id);
        return zhiX;
    }

    /**
     * 查询我的自选
     * userID
     * 1、optional表，找到基金，再根据工具，找到基金详细信息，再记录到optional中
     * 返回一个Vo包装类
     */
    @GetMapping("/selectMy")
    public AppResponse<Object> SelectMy(@RequestParam("userId") String userId,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "16") Integer pageSize){


        AppResponse resp;
        try {
            Integer id= Integer.parseInt(userId);
            OptPageListVo optPageListVo = new OptPageListVo();
            int total = tOptionalService.countOptbyUserId(id);
            optPageListVo.setTotal(total);
            // 自选集合 ,原始数据
            List<TOptional>  list = tOptionalService.selectMyOpt(id,pageNum,pageSize);
            if (list.size() == 0){
                resp = AppResponse.fail(null);
                resp.setMsg("未添加自选");
                return resp;
            }
            // 返回自选列表
            List<OptVo> listVo = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                // 这个一定要放到循环里
                OptVo optVo = new OptVo();

                Integer fundId = list.get(i).getFundId();
                TFund tFund =  tFundService.selectFundById(fundId);
                if (tFund == null){
                    resp = AppResponse.fail(null);
                    resp.setMsg("基金不存在");
                    return resp;
                }

                String fundCode = tFund.getFundCode();
                String status = tFund.getFundStatus();
                // 在线补全信息

                JSONObject code7Info = FundUtils.getByFundCode_7Info(fundCode);
                // 录入返回信息

                optVo.setOptId(list.get(i).getOptId());
                optVo.setUserId(list.get(i).getUserId());
                optVo.setFundId(fundId);
                // 记得更新昨日净值和百分率。其实也用不上，展示不用
                optVo.setOptPrice(list.get(i).getOptPrice());
                // 天数差，自选日期和净值日期
                Date optDate = list.get(i).getOptDate();
                String jzrp = code7Info.getString("jzrq");

                Date date = AppDateUtils.StringToDate(jzrp);

                int days = AppDateUtils.DayNum(date, optDate);

                // 时间没有存，每次查都要算。
                optVo.setDays(days);
                // 昨日净值和持有时的净值差，再比持有时净值，就是百分率。（这个放到定时器里去更新。）时间差，也是。展示用String，数据库存用data。
              //  optVo.setOptProfitProp(list.get(i).getOptProfitProp());

                // 开始更新8个数据
                optVo.setFundStatus(status);
                optVo.setFundCode(fundCode);
                optVo.setName(tFund.getFundName());
                optVo.setJzrq(code7Info.getString("jzrq"));
                String dwjz = code7Info.getString("dwjz");
                BigDecimal big1 = new BigDecimal(dwjz);
                optVo.setDwjz(big1);
                BigDecimal big2 = new BigDecimal(code7Info.getString("gsz"));
                optVo.setGsz(big2);
                String gszzl = code7Info.getString("gszzl");
                BigDecimal big3 = new BigDecimal(gszzl);
                optVo.setGszzl(big3);
                optVo.setGztime(code7Info.getString("gztime"));
                // 是否持有
                optVo.setChiY(isChiY(fundCode,userId));
                optVo.setZhiX(isZhiX(fundCode,userId));
                // 封装结束。
                listVo.add(optVo);
            }
            optPageListVo.setRecords(listVo);
            return AppResponse.ok(optPageListVo);
        } catch (Exception e) {
            e.printStackTrace();
            resp = AppResponse.fail(null);
            resp.setMsg("操作异常");
            return resp;
        }
    }


    /**
     * 添加到我的自选
     * 返回 添加成功信息
     */
    @GetMapping("/addMy")
    public AppResponse<Object> addMy(@RequestParam("fundCode") String fundCode,@RequestParam("userId") String userId) throws Exception {
        AppResponse resp;

        int i = tOptionalService.addMyOpt(fundCode,userId);
        if (i == 1){
            resp = AppResponse.ok("ok");
            resp.setMsg("添加到自选成功");
            return resp;
        }else if(i == 0){
            resp = AppResponse.fail(null);
            resp.setMsg("添加自选失败");
            return resp;
        }else if (i == 2){
            resp = AppResponse.fail(null);
            resp.setMsg("已经添加过自选");
            return resp;
        }else {
            resp = AppResponse.fail(null);
            resp.setMsg("不明异常");
            return resp;
        }
    }


    /**
     * 移除我的自选
     * 返回移除成功信息
     */
    @DeleteMapping("/deleteMy/{fundCode}/{userId}")
    public AppResponse<Object> deleteMy( @PathVariable String fundCode,@PathVariable String userId){
        AppResponse resp;

        // 放到Service中去转换类型
        int i = tOptionalService.deleteMy(fundCode,userId);
        if (i == 1){
            resp = AppResponse.ok("ok");
            resp.setMsg("删除自选成功");
            return resp;
        }else {
            resp = AppResponse.fail(null);
            resp.setMsg("删除自选失败");
            return resp;
        }
    }
}
