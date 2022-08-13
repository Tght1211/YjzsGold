package com.yjzs.gold.nouse;

import com.alibaba.fastjson.JSONObject;
import com.yjzs.gold.utils.FundTime;
import com.yjzs.gold.utils.FundUtils;

import java.util.Arrays;

/**
 * array(7) {
 * ["fundcode"]=>"519983"           //基金代码
 * ["name"]=>"长信量化先锋混合A"    //基金名称
 * ["jzrq"]=>"2018-09-21"           //净值日期
 * ["dwjz"]=>"1.2440"               //当日净值
 * ["gsz"]=>"1.2388"                //估算净值
 * ["gszzl"]=>"-0.42"               //估算涨跌百分比 即-0.42%
 * ["gztime"]=>"2018-09-25 15:00"   //估值时间
 * }
 *
 * @author Tght
 */
public class Solution {

    public static boolean check(String A, String B) {

        if(A.length() != B.length()){
            return false;
        }
        //大字符串
        String C = A+A ;

        return C.contains(B);
    }
    public static void main(String[] args) {
        boolean check = Solution.check("acbdef", "bdefac");
        System.out.println(check);
    }
}


//        JSONObject fundgz = FundUtils.getByFundCode_7Info("008888");
//     FundUtils.getByFundCode_Info("008888");
//    System.out.println(fundgz.getString("name"));

//  String [] arr = {"012414", "008888", "001593", "012755", "013081", "008155", "006229", "001156"};
//  FundTime.getFund(arr);


/*int[] arr = {4, 3, 7, 2, 6, 1, 5};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/