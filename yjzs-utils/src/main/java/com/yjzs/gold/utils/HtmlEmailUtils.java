package com.yjzs.gold.utils;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Random;

/**
 * @author Tght
 */
public class HtmlEmailUtils {


    /**
     * 提供一些默认的信息
     */
    public static String reg_greet = "养基人，您好!";
    public static String reg_purpose = "我只会告诉充满智慧的投资者，您加入我们 所需的 养基助手 验证码为:";
    public static String start_code = "W6QNK";
    public static String log_greet = "tght1211,您好!";
    public static String log_purpose = "您登陆账户 tght1211 所需的 养基助手 验证码为:";
    public static String bot_explain_one = "祝您愉快，";
    public static String bot_explain_two = "养基助手团队";
    public static String SMTP_163 = "smtp.163.com";
    public static String SMTP_qq = "smtp.qq.com";
    public static String from_Email_163_yjzs = "yjzs_gold@163.com";
    public static String from_Email_163_176 = "17674009984@163.com";
    public static String from_Email_163_wj08 = "wj08524825@163.com";
    public static String from_Email_163_qq2500851731 = "qq250085173@163.com";
    public static String from_Email_qq = "2500851731@qq.com";
    public static String from_Name = "养基助手";
    public static String from_User_Key_163_yjzs_gold = "SOOTUQOIOYDIGZNF";
    public static String from_User_Key_163_17674009984 = "QASBTKIFYKFWVRPK";
    public static String from_User_Key_163_wj08524825 = "KKTWZKPXJFEGWDOZ";
    public static String from_User_Key_163_qq2500851731 = "PYSQUGGGPVMBJWUP";
    public static String from_User_Key_qq_2500851731 = "xnymuwnvvatwebie";

    public static String Email_theme = "你好呀！年轻人";


    /**
     * QQ和163轮询,共四台。
     *
     * @param toEmail
     * @return
     */
    public static AppResponse<String> sendReg(String toEmail) {
        Random random = new Random();
        int ran = random.nextInt(100);
        AppResponse result;
        if (ran < 20 && ran >= 0) {
            result = sendQQReg(toEmail);
        } else {
            result = send163Reg(toEmail);
        }
        result = AppResponse.ok(result.getData());
        return result;
    }

    public static AppResponse<String> sendLog(String nickName, String toEmail) {
        Random random = new Random();
        int ran = random.nextInt(100);
        AppResponse result;
        if (ran < 20 && ran >= 0) {
            result = sendQQLog(nickName, toEmail);
        } else {
            result = send163Log(nickName, toEmail);
        }
        result = AppResponse.ok(result.getData());
        return result;
    }


    public static AppResponse<String> sendQQReg(String toEmail) {
        String editor = initReg();
        AppResponse result = sendHtmlEmailQQ(editor, toEmail);
        result = AppResponse.ok(result.getData());
        return result;
    }

    public static AppResponse<String> send163Reg(String toEmail) {
        String editor = initReg();
        AppResponse<String> result = robbon_email(editor, toEmail);
        result = AppResponse.ok(result.getData());
        return result;
    }


    public static AppResponse<String> sendQQLog(String nickName, String toEmail) {
        String editor = initLog(nickName, toEmail);
        AppResponse result = sendHtmlEmailQQ(editor, toEmail);
        result = AppResponse.ok(result.getData());
        return result;
    }

    public static AppResponse<String> send163Log(String nickName, String toEmail) {
        String editor = initLog(nickName, toEmail);
        AppResponse<String> result = robbon_email(editor, toEmail);
        result = AppResponse.ok(result.getData());
        return result;
    }

    public static AppResponse<String> robbon_email(String editor,String toEmail){
        Random random = new Random();
        int ran = random.nextInt(100);
        AppResponse result;
        if (ran < 25 && ran >= 0) {
            result = sendHtmlEmail1631(editor, toEmail);
        } else if (ran >= 25 && ran < 50) {
            result = sendHtmlEmail1632(editor, toEmail);
        } else if (ran >= 50 && ran < 75){
            result = sendHtmlEmail1633(editor, toEmail);
        }else {
            result = sendHtmlEmail1634(editor, toEmail);
        }
        return result;
    }


    public static String createCode() {
        Random random = new Random();
        int[] nums = new int[6];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            do {
                nums[i] = random.nextInt(123);
                if (nums[i] >= 0 && nums[i] <= 9) {
                    System.out.print(nums[i]);
                    stringBuilder.append(nums[i]);
                    break;
                } else if (nums[i] >= 65 && nums[i] <= 90) {
                    char num = (char) nums[i];
                    System.out.print(num);
                    stringBuilder.append(num);
                    break;
                }/*else if(nums[i] >= 97 && nums[i] <= 122){   不用小写字母
                    char num = (char) nums[i];
                    System.out.print(num);
                    break;
                }*/
            } while (true);
        }

        return stringBuilder.toString();
    }


    public static String initReg() {
        String code = createCode();
        start_code = code;
        return EditorHtml(reg_greet, reg_purpose, code);
    }

    public static String initLog(String nickName, String email) {
        String greet = nickName + "，您好！";
        String purpose = "您登陆账户 " + email + " 所需的 养基助手 验证码为:";
        String code = createCode();
        start_code = code;
        return EditorHtml(greet, purpose, code);
    }

    /**
     * 问候+说明+验证码
     *
     * @param greet
     * @param purpose
     * @param code
     * @return
     */
    public static String EditorHtml(String greet, String purpose, String code) {
        return getString(greet, purpose, code, bot_explain_one, bot_explain_two);
    }

    /**
     * 可以编辑最后的祝福
     *
     * @param greet
     * @param purpose
     * @param code
     * @param explain_one
     * @param explain_two
     * @return
     */
    public static String EditorHtml(String greet, String purpose, String code, String explain_one, String explain_two) {

        return getString(greet, purpose, code, explain_one, explain_two);
    }

    private static String getString(String greet, String purpose, String code, String explain_one, String explain_two) {
        String result = "<div class=\"box\" style=\" \n" +
                "    margin: 0 auto;\n" +
                "    padding: 0;\n" +
                "    background-color: #212429;\n" +
                "    width: 100%;\n" +
                "    height: 100%;\n" +
                "    \">\n" +
                "        <div>\n" +
                "            <p class=\"title\" style=\" color: #bfbfbf;  margin: 0 10%; padding-top: 5%;\n" +
                "        font-size: 45px; font-family: 黑体;\">" +
                greet +
                "</p>\n" +
                "            <p class=\"inner\" style=\" color: #bfbfbf; margin: 40px 10%;\n" +
                "        font-size: 30px; font-family: 黑体;\">" +
                purpose +
                "</p>\n" +
                "            <div class=\"bottom\" style=\"\n" +
                "            margin: 0 10%;\n" +
                "        text-align: center;\n" +
                "        padding-top: 2%;\n" +
                "        padding-bottom: 2%;\n" +
                "        width: 80%;\n" +
                "        height: 40%;\n" +
                "        background-color: #17191c;\n" +
                "        \">\n" +
                "                <p class=\"code\" style=\"font-size: 45px;\n" +
                "          color: #3a9aed;\">" +
                code +
                "</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div style=\"height: 40px;background-color: #212429;\">\n" +
                "        \n" +
                "        </div>\n" +
                "        <div style=\"height: 300px;background-color: #212429;\">\n" +
                "            <div style=\"margin: 0 10%; font-size: 20px;\">\n" +
                "                <blockquote style=\"margin: 16px 0;padding: 0 15px;  background: #212429;\n" +
                "                border-left: 5px solid #3a9aed;\n" +
                "                margin: 1.5em 5px;\n" +
                "                padding: 0.5em 5px;\">\n" +
                "                    <p style=\"color: #ffffff; margin-left: 20px;\">" +
                explain_one +
                "</p>\n" +
                "                    <p style=\"color: #ffffff; margin-left: 20px;\">" +
                explain_two +
                "</p>\n" +
                "                </blockquote>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>";
        return result;
    }

    public static AppResponse<String> sendHtmlEmailQQ(String Editor, String toEmail) {
        return initHtmlEmail(Editor, SMTP_qq, from_Email_qq, toEmail, from_Name, from_Email_qq, from_User_Key_qq_2500851731, Email_theme);
    }

    public static AppResponse<String> sendHtmlEmail163init(String Editor, String toEmail, String from_Email_163_, String from_User_Key_163_) {
        return initHtmlEmail(Editor, SMTP_163, from_Email_163_, toEmail, from_Name, from_Email_163_, from_User_Key_163_, Email_theme);
    }

    public static AppResponse<String> sendHtmlEmail1631(String Editor, String toEmail) {
        return sendHtmlEmail163init(Editor, toEmail, from_Email_163_yjzs, from_User_Key_163_yjzs_gold);
    }

    public static AppResponse<String> sendHtmlEmail1632(String Editor, String toEmail) {
        return sendHtmlEmail163init(Editor, toEmail, from_Email_163_176, from_User_Key_163_17674009984);
    }

    public static AppResponse<String> sendHtmlEmail1633(String Editor, String toEmail) {
        return sendHtmlEmail163init(Editor, toEmail, from_Email_163_wj08, from_User_Key_163_wj08524825);
    }
    public static AppResponse<String> sendHtmlEmail1634(String Editor, String toEmail) {
        return sendHtmlEmail163init(Editor, toEmail, from_Email_163_qq2500851731, from_User_Key_163_qq2500851731);
    }


    public static AppResponse<String> initHtmlEmail(String Editor, String SMTP, String fromEmail, String toEmail, String formName, String formUserAcc, String fromUserKye, String EmailTheme) {
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName(SMTP);
            // 字符编码集的设置
            email.setCharset("utf-8");
            // 收件人的邮箱//17674009984@163.com\tght_1211@163.com
            email.addTo(toEmail);
            // 发送人的邮箱2
            email.setFrom(fromEmail, formName);
            // 如果需要认证信息的话，设置认证：用户名-密码     ***是你开启POP3服务时的授权码，不是登录密码
            email.setAuthentication(formUserAcc, fromUserKye);
            // 要发送的邮件主题
            email.setSubject(EmailTheme);
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            // 第一个可以用来忘记密码
            email.setMsg(Editor);
            // 发送
            email.send();
            System.out.println("发送成功");
            AppResponse resp = AppResponse.ok(start_code);
            resp.setMsg("发送成功");
            return resp;
        } catch (EmailException e) {
            e.printStackTrace();
            System.out.println("发送失败");
            AppResponse resp = AppResponse.fail(null);
            resp.setMsg("发送失败");
            return resp;
        }
    }

}
