package com.yjzs.gold.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.yjzs.gold.main.bean.TFund;
import com.yjzs.gold.main.service.TFundService;
import com.yjzs.gold.main.service.TOptionalService;
import com.yjzs.gold.main.service.TSupportService;
import com.yjzs.gold.main.vo.resp.FundPageListVo;
import com.yjzs.gold.main.vo.resp.FundVo;
import com.yjzs.gold.utils.AppResponse;
import com.yjzs.gold.utils.FundUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.params.shadow.com.univocity.parsers.common.NormalizedString.toArray;


/**
 * @author Tght
 * @RefreshScope 配置自动刷新
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/main/fund")
public class FundController {

    @Autowired
    TFundService tFundService;

    @Autowired
    TSupportService tSupportService;

    @Autowired
    TOptionalService tOptionalService;

    /**
     * // 将四个信息的数据库基金，跟接口转换
     *
     * @param code
     * @param status
     * @return
     * @throws Exception
     */
    public FundVo fundZhuang(String code, String status) {
        try {
            JSONObject code7Info = FundUtils.getByFundCode_7Info(code);
            FundVo fundVo = new FundVo();
            fundVo.setFundStatus(status);
            fundVo.setFundCode(code);
            fundVo.setFundName(code7Info.getString("name"));
            fundVo.setJzrq(code7Info.getString("jzrq"));
            fundVo.setDwjz(code7Info.getString("dwjz"));
            fundVo.setGsz(code7Info.getString("gsz"));
            String gszzl = code7Info.getString("gszzl");
            BigDecimal bigDecimal = new BigDecimal(gszzl);
            fundVo.setGszzl(bigDecimal);
            fundVo.setGztime(code7Info.getString("gztime"));
            return fundVo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
     * 去养基表查看,持有人数
     */
    public int selectNum(String fundCode){

        int num = tSupportService.selectNum(fundCode);
        return num;
    }


    /**
     * 辨别输入的是基金代码还是基金名称
     * 代码若是找不到,就添加.    找到了,就显示.   前端再判断状态是否可用,可用再显示
     *
     * 基金名称,模糊搜索.
     * 若找不到,提示你 输入基金代码.
     * selectFundCode 是模糊查询
     * selectFundCodeNoLike 是普通查询
     */

    public AppResponse<Object> selFundCode(String fundCode,String userId,Integer pageNum,Integer pageSize){
        AppResponse resp = new AppResponse();
        try {
            // 与分页相关,返回集合和total.
            int total = tFundService.countFundByCode(fundCode);
            FundPageListVo fundPageListVo = new FundPageListVo();
            fundPageListVo.setTotal(total);
            // 原数据
            List<TFund> list = tFundService.selectFundCode(fundCode,pageNum,pageSize);
            List<FundVo> listVo = new ArrayList<>();
            // 不存在
            if (list == null) {
                // 校验基金代码是否正确

                char[] chars = fundCode.toCharArray();
                if (chars.length == 6){
                    try {
                        FundUtils.getByFundCode_7Info(fundCode);
                    } catch (Exception e) {
                        resp.setMsg("请输入正确的基代码");
                        resp = AppResponse.fail(null);
                        return resp;
                    }
                    int i = tFundService.addFundCode(fundCode);
                    if (i == 1) {
                        resp.setMsg("添加基金代码成功");
                        // 添加成功后，再查询一遍。
                        TFund tFund1 = (TFund) list;
                        String code = tFund1.getFundCode();
                        String status = tFund1.getFundStatus();
                        // 将四个信息的数据库基金，跟接口转换
                        FundVo fundVo = fundZhuang(code, status);
                        if (fundVo != null) {
                            //补充持有和人数字段和自选信息
                            String chiY = isChiY(code, userId);
                            fundVo.setChiY(chiY);
                            fundVo.setNum(selectNum(code));
                            fundVo.setZhiX(isZhiX(code, userId));
                            listVo.add(fundVo);
                            return AppResponse.ok(listVo);
                        }else {
                            resp.setMsg("请输入正确的基代码");
                            resp = AppResponse.fail(null);
                            return resp;
                        }
                    } else {
                        resp.setMsg("添加基金代码失败");
                        resp = AppResponse.fail(null);
                        return resp;
                    }
                }else {

                    resp = AppResponse.fail(null);
                    resp.setMsg("不存在该基金代码");
                    return resp;
                }
            } else {
                // 存在

                for (int i = 0; i < list.size(); i++) {
                    String code = list.get(i).getFundCode();
                    String status = list.get(i).getFundStatus();

                    FundVo fundVo = fundZhuang(code, status);
                    if (fundVo != null) {
                        //补充持有和人数字段和自选信息
                        String chiY = isChiY(code, userId);
                        fundVo.setChiY(chiY);
                        fundVo.setNum(selectNum(code));
                        fundVo.setZhiX(isZhiX(code, userId));
                        // 注意是加入8字段的返回Vo
                        listVo.add(fundVo);
                    }else {
                        resp.setMsg("请输入正确的基代码");
                        resp = AppResponse.fail(null);
                        return resp;
                    }
                }
                //降序排序
                listVo = listVo.stream().sorted(Comparator.comparing(FundVo::getGszzl).reversed()).collect(Collectors.toList());
                // Collections.sort(listVo, Comparator.comparing(FundVo::getGszzl).reversed());
                fundPageListVo.setRecords(listVo);
                return AppResponse.ok(fundPageListVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp = AppResponse.fail(null);
            resp.setMsg("查找基金异常");
            return resp;
        }
    }


    public AppResponse<Object> selFundName(String fundName,String userId,Integer pageNum,Integer pageSize){
        AppResponse resp = new AppResponse();

        // 与分页相关,返回集合和total.
        int total = tFundService.countFundByName(fundName);
        FundPageListVo fundPageListVo = new FundPageListVo();
        fundPageListVo.setTotal(total);
        // 模糊查询,去加%%
        List<TFund> list = tFundService.selectFundByName(fundName,pageNum,pageSize);
        List<FundVo> listVo = new ArrayList<>();
        if (list == null) {
            resp.setMsg("请试试输入基金代码");
            return resp;
        }else {
            for (int i = 0; i < list.size(); i++) {
                // 存在.
                String code = list.get(i).getFundCode();
                String status = list.get(i).getFundStatus();

                FundVo fundVo = fundZhuang(code, status);
                if (fundVo != null) {
                    //补充持有和人数字段和自选信息
                    String chiY = isChiY(code, userId);
                    fundVo.setChiY(chiY);
                    fundVo.setNum(selectNum(code));
                    fundVo.setZhiX(isZhiX(code, userId));
                    listVo.add(fundVo);
                }else {
                    resp.setMsg("请输入正确的基代码");
                    resp = AppResponse.fail(null);
                    return resp;
                }
            }
            fundPageListVo.setRecords(listVo);
            return AppResponse.ok(fundPageListVo);
        }
    }

    /**
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */

    private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    public static boolean isInteger(String str) {
        // 使用预编译.更快
        Pattern pattern = NUMBER_PATTERN;
        return pattern.matcher(str).matches();
    }

    /**
     * 选基。(包含添加，查询，状态鉴别只能给前端)
            * 存在就找出来，不存在就添加。
            * 去业务层校验fundCode
     * 返回的对象只有四个属性，并不适合传递出去。
            * 再包装以下返回数据。7个属性的那个
     * @RequestParam  只能与@GetMapping一起用
     */
    @GetMapping("/selectAdd")
    public AppResponse<Object> SelectAdd(@RequestParam("strLike")String strLike,
                                         @RequestParam("userId")String userId,
                                         @RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "16") Integer pageSize){
        AppResponse<Object> response;

        if (isInteger(strLike)){
            //是数字为基金代码
            response = selFundCode(strLike, userId,pageNum,pageSize);
        }else {
            response = selFundName(strLike, userId,pageNum,pageSize);
        }
        return response;
    }

    /**
     * 直接罗列出所有基金，不用排序。
     * 返回有8+2大状态的基金。状态鉴别只能给前端
     *
     * 其实只改变页数.
     * @return
     * @throws Exception
     *  @SneakyThrows
     */
    @GetMapping("/select")
    public AppResponse<Object> selectFund(@RequestParam("userId")String id,
                                          @RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "16") Integer pageSize){


        try {
            // 原始数据
            System.out.println("进来了");
            List<TFund> list = tFundService.selectFund(pageNum,pageSize);
            List<FundVo> listVo = new ArrayList<>();
            int total = tFundService.countFund();
            // 与分页相关,返回集合和total.
            FundPageListVo fundPageListVo = new FundPageListVo();
            fundPageListVo.setTotal(total);
            int size = list.size();

            for (int i = 0; i < size; i++) {
                String code = list.get(i).getFundCode();
                String status = list.get(i).getFundStatus();
                FundVo fundVo = fundZhuang(code, status);

                if (fundVo != null) {
                    //补充持有和人数字段
                    String chiY = isChiY(fundVo.getFundCode(), id);
                    fundVo.setChiY(chiY);

                    fundVo.setNum(selectNum(fundVo.getFundCode()));
                    fundVo.setZhiX(isZhiX(code, id));
                    // 注意是加入8字段的返回Vo
                    listVo.add(fundVo);
                }else {
                    return AppResponse.fail(null);
                }
            }
            //排序一下,估算涨跌最大的放前面.
            listVo = listVo.stream().sorted(Comparator.comparing(FundVo::getGszzl).reversed()).collect(Collectors.toList());
            fundPageListVo.setRecords(listVo);
            // 返回包装了集合和total的数据
            return AppResponse.ok(fundPageListVo);
        } catch (Exception e) {
            e.printStackTrace();
            return AppResponse.fail(null);
        }
    }
}
