package com.yjzs.gold.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tght
 */
public class AccountORUtils {

    /**
     * 验证邮箱
     */

    public static AppResponse<String> checkAccount(String account) {

        if (!StringUtils.isEmpty(account)) {
            boolean emailOR = checkEmail(account);
            boolean phoneOR = checkMobileNumber(account);
            if (emailOR){
                AppResponse resp = AppResponse.ok("email");
                resp.setMsg("账户为邮箱");
                return resp;
            }else if (phoneOR){
                AppResponse resp = AppResponse.ok("phone");
                resp.setMsg("账户为手机号");
                return resp;
            }else {
                AppResponse resp = AppResponse.fail(null);
                resp.setMsg("请输入正确的手机号或邮箱");
                return resp;
            }
        } else {
            AppResponse resp = AppResponse.fail(null);
            resp.setMsg("账户为空");
            return resp;
        }
    }

    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码，11位数字，1开通，第二位数必须是3456789这些数字之一 *
     *
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            String check = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

}
