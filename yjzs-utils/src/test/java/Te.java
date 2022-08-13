import com.yjzs.gold.utils.AppResponse;
import com.yjzs.gold.nouse.EmailUtil;


import com.yjzs.gold.utils.HtmlEmailUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;



public class Te {
    @Test
    public void test1() throws Exception {
        /*2227321254@qq.com*/
        String toEmail = "tght_1211@163.com";
        String html = "";
        String title = "这是一封测试邮件";

        // 这太复杂的干不了
        EmailUtil.sendEmail(toEmail,title,html,"text");
    }

    @Test
    public void test02(){
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName("smtp.163.com");
            // 字符编码集的设置
            email.setCharset("utf-8");
            // 收件人的邮箱
            email.addTo("tght_1211@163.com");//17674009984@163.com
            // 发送人的邮箱2
            email.setFrom("yjzs_gold@163.com", "养基助手");
            // 如果需要认证信息的话，设置认证：用户名-密码     ***是你开启POP3服务时的授权码，不是登录密码
            email.setAuthentication("yjzs_gold@163.com", "SOOTUQOIOYDIGZNF");
            // 要发送的邮件主题
            email.setSubject("你好呀，年轻人！");
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            // 第一个可以用来忘记密码
            email.setMsg("<div class=\"box\" style=\" \n" +
                    "    margin: 0 auto;\n" +
                    "    padding: 0;\n" +
                    "    background-color: #212429;\n" +
                    "    width: 100%;\n" +
                    "    height: 100%;\n" +
                    "    \">\n" +
                    "        <div>\n" +
                    "            <p class=\"title\" style=\" color: #bfbfbf;  margin: 0 10%; padding-top: 5%;\n" +
                    "        font-size: 45px; font-family: 黑体;\">tght1211,您好!</p>\n" +
                    "            <p class=\"inner\" style=\" color: #bfbfbf; margin: 40px 10%;\n" +
                    "        font-size: 30px; font-family: 黑体;\">您登陆账户 tght1211 所需的 养基助手 验证码为:</p>\n" +
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
                    "          color: #3a9aed;\">W6QNK</p>\n" +
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
                    "                    <p style=\"color: #ffffff; margin-left: 20px;\">祝您愉快，</p>\n" +
                    "                    <p style=\"color: #ffffff; margin-left: 20px;\">养基助手团队</p>\n" +
                    "                </blockquote>\n" +
                    "\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>");


            String register = "<div class=\"box\" style=\" \n" +
                    "    margin: 0 auto;\n" +
                    "    padding: 0;\n" +
                    "    background-color: #212429;\n" +
                    "    width: 100%;\n" +
                    "    height: 100%;\n" +
                    "    \">\n" +
                    "        <div>\n" +
                    "            <p class=\"title\" style=\" color: #bfbfbf;  margin: 0 10%; padding-top: 5%;\n" +
                    "        font-size: 45px; font-family: 黑体;\">养基人，您好!</p>\n" +
                    "            <p class=\"inner\" style=\" color: #bfbfbf; margin: 40px 10%;\n" +
                    "        font-size: 30px; font-family: 黑体;\">我只会告诉充满智慧的投资者，您加入我们 所需的 养基助手 验证码为:</p>\n" +
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
                    "          color: #3a9aed;\">W6QNK</p>\n" +
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
                    "                    <p style=\"color: #ffffff; margin-left: 20px;\">祝您愉快，</p>\n" +
                    "                    <p style=\"color: #ffffff; margin-left: 20px;\">养基助手团队</p>\n" +
                    "                </blockquote>\n" +
                    "\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>";
            // 发送
            email.send();
            System.out.println("发送成功");
        } catch (EmailException e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }
    }

    @Test
    public void test03(){
        String Email = "3167108896@qq.com";//3167108896@qq.com
        AppResponse resp = HtmlEmailUtils.sendReg(Email);
        String code = (String)resp.getData();

    }
}
