package com.yjzs.gold.nouse;

import com.alibaba.fastjson.JSONObject;
import com.yjzs.gold.utils.FundTime;
import com.yjzs.gold.utils.FundUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Tght
 */
public class SignIn {

    public static void main(String[] args) throws Exception {
       // String [] arr = {"012414", "008888", "001593", "012755", "013081", "008155", "006229", "001156"};
    //    JSONObject code7Info = FundUtils.getByFundCode_7Info("008888");
      //  System.out.println(code7Info.toString());
        // FundTime.getFund(arr);

//        BigDecimal bg = new BigDecimal();
//      double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//      System.out.println(f1);
        String str="-2.30";
        BigDecimal bd=new BigDecimal(str);
        System.out.println(bd);
    }
}
