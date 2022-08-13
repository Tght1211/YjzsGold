package com.yjzs.gold.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *   @author Tght
 *   1、实现获取单个基金信息   √
 *   2、实现获取单个基金的曲线信息
 *   3、将曲线信息记录到redis，时间：--%
 *
 * array(7) {
 * 	  ["fundcode"]=>"519983"           //基金代码
 * 	  ["name"]=>"长信量化先锋混合A"    //基金名称
 * 	  ["jzrq"]=>"2018-09-21"           //净值日期
 * 	  ["dwjz"]=>"1.2440"               //当日净值
 * 	  ["gsz"]=>"1.2388"                //估算净值
 * 	  ["gszzl"]=>"-0.42"               //估算涨跌百分比 即-0.42%
 * 	  ["gztime"]=>"2018-09-25 15:00"   //估值时间
 *        }
 *
 *        https://j4.dfcfw.com/charts/pic6/008888.png  获取当日基金的走势图
 *        http://fundgz.1234567.com.cn/js/001186.js?rt=1463558676006 获取基金实时信息： 7个
 *        http://fund.eastmoney.com/js/fundcode_search.js  获取全部： 基金代码 + 名称 + 类型
 *        http://fund.eastmoney.com/js/jjjz_gs.js?dt=1463791574015 获取所有：基金公司代码 + 名称
 *        http://fund.eastmoney.com/pingzhongdata/001186.js?v=20160518155842 获取基金详细信息（非常多）
 *        http://j4.dfcfw.com/charts/pic6/008888.png?v=20220407115053?v=0.04261597224339897  当日基金估值图（天天基金）
 *
 *        <a href="https://adain.top/fund2/index.html">https://adain.top/fund2/index.html</a>
 *
 *        // 上证和深证
 *        {
 * "f1": 2,
 * "f2": 319403,
 * "f3": -5,
 * "f4": -149,
 * "f6": 362769874944,
 * "f12": "000001",
 * "f13": 1,
 * "f14": "上证指数",
 * "f104": 1133,
 * "f105": 933,
 * "f106": 57,
 * "f152": 2
 * },
 *        //上证：3194.03 ↓-1.49 -0.05% 3628亿元(涨:1133 平:57 跌:933) 深证：11633.32 ↓-58.15 -0.50% 4166亿元(涨:1597 平:82 跌:974) 
 *        http://push2.eastmoney.com/api/qt/ulist/get?fltt=1&invt=2&cb=jQuery351044289171266072613_1650365912029&fields=f12%2Cf13%2Cf14%2Cf1%2Cf2%2Cf4%2Cf3%2Cf152%2Cf6%2Cf104%2Cf105%2Cf106&secids=1.000001%2C0.399001&ut=fa5fd1943c7b386f172d6893dbfba10b&pn=1&np=1&wbp2u=%7C0%7C0%7C0%7Cweb&_=1650365912085
 */
public class FundUtils {

    /**
     * 根据基金代码实时获取基金数据
     * 基金代码、基金名称、净值日期、当日净值、估算净值、估算涨跌百分比、估算时间  7个数据
     *
     * @param fundCode
     * @return
     * @throws Exception
     */
    public static JSONObject getByFundCode_7Info(String fundCode) throws Exception {
        long timeNew = System.currentTimeMillis();
        String url = "http://fundgz.1234567.com.cn/js/" + fundCode + ".js?rt=" + timeNew;

        Document document =
                Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36").ignoreContentType(true).get();
        Element body = document.body();
        String text = body.text();
        String str1 = text.replace("jsonpgz(", "[");
        String str2 = str1.replace(");", "]");

        JSONArray temp = JSONArray.parseArray(str2);

        JSONObject obj = null;
        for (int i = 0; i < temp.size(); i++) {
            obj = (JSONObject) temp.get(i);
        }
        return obj;
    }

    /**
     * 所有基金接口
     * 不太好弄，先放着
     * @param fundCode
     * @throws Exception
     */
    public static void getByFundCode_Info(String fundCode) throws Exception {
        long  timeNew =  System.currentTimeMillis();
        String url = "http://fund.eastmoney.com/pingzhongdata/"+fundCode+".js?v="+timeNew;
        Document document =
                Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36").ignoreContentType(true).get();
        Element body = document.body();
        String text = body.text();
        System.out.println(text);
    }

}
