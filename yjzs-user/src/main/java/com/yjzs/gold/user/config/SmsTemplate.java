package com.yjzs.gold.user.config;


import com.yjzs.gold.utils.AppResponse;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SmsTemplate {

    /**
     * 通过$来获取属性文件中的数据
     */
    @Value("${sms.host}")
    String host;
    @Value("${sms.path}")
    String path;
    @Value("${sms.method}")
    String method;
    @Value("${sms.appcode}")
    String appcode;

    public AppResponse<String> sendSms(Map<String, String> querys) {

        // 31e364298648476da5cac4aa78719bc0
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        //  headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> bodys = new HashMap<String, String>();

        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
            return AppResponse.ok(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return AppResponse.fail(null);
        }
    }
}
