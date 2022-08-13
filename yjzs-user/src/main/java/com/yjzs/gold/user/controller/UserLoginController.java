package com.yjzs.gold.user.controller;


import com.yjzs.gold.user.bean.TUser;
import com.yjzs.gold.user.config.OssTemplate;
import com.yjzs.gold.user.config.SmsTemplate;
import com.yjzs.gold.user.service.TUserService;
import com.yjzs.gold.user.vo.req.UserRegistVo;
import com.yjzs.gold.user.vo.resp.UserRespVo;

import com.yjzs.gold.utils.AccountORUtils;
import com.yjzs.gold.utils.AppDateUtils;
import com.yjzs.gold.utils.AppResponse;
import com.yjzs.gold.utils.HtmlEmailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @author Tght
 * @RefreshScope 配置自动刷新
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/start")
public class UserLoginController {

    @Autowired
    SmsTemplate smsTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    TUserService tUserService;


    @Autowired
    OssTemplate ossTemplate;

    /**
     * 文件上传表单提交要求：
     * 1、method="'post"
     * 2、enctype="multipart/from-data"
     * 3、type="file" name="uploadfile"
     * <p>
     * SpringMVC框架集成commons-fileupload和commons-io组件，完成文件上传操作
     * SpringMVC提供了文件上传解析器。
     * Controller处理文件上传时，通过MultipartFile接收文件。
     *
     * @return
     */
    @CrossOrigin
    @PostMapping("/imageUrl")
    public AppResponse<Object> image(MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            filename = UUID.randomUUID().toString().replaceAll("-", "") + "-" + filename;
            String filePath = ossTemplate.upload(filename, file.getInputStream());
            return AppResponse.ok(filePath);
        } catch (Exception e) {
            return AppResponse.fail(null);
        }
    }


    /**
     * 账号密码-登录
     */
    @GetMapping("/login")
    public AppResponse<UserRespVo> login(@RequestParam("account") String account, @RequestParam("password") String password) {

        log.debug("登录表单数据account-{}", account);
        log.debug("登录表单数据password-{}", password);

        TUser tUser = tUserService.getUserbyLogin(account, password);
        AppResponse<UserRespVo> resp;
        if (tUser == null) {
            log.debug("登录失败-{}", account);
            resp = AppResponse.fail(null);
            resp.setMsg("登录失败");
            return resp;
        } else {
            UserRespVo respVo = new UserRespVo();
            // 生成token，UUID可能有-，要全部替换成空
            String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
            respVo.setAccessToken(accessToken);
            respVo.setUserCreateTime(tUser.getUserCreateTime());
            respVo.setUserNickName(tUser.getUserNickName());
            respVo.setUserStatus(tUser.getUserStatus());
            respVo.setUserType(tUser.getUserType());
            if (tUser.getUserAccount() != null){
                respVo.setUserAccount(tUser.getUserAccount());
            }else {
                respVo.setUserEmail(tUser.getUserEmail());
            }
            respVo.setUserImgUrl(tUser.getUserImgUrl());
            respVo.setUserSex(tUser.getUserSex());
            respVo.setUserPlate(tUser.getUserPlate());
            //获取用户id
            respVo.setUserId(tUser.getUserId());
            // 登录后将accessToken和用户id缓存到Redis,设置失效时间
            stringRedisTemplate.opsForValue().set(accessToken, respVo.getUserId().toString(), 30, TimeUnit.MINUTES);
            log.debug("登录成功-{}", account);
            resp = AppResponse.ok(respVo);
            resp.setMsg("登录成功");
            return resp;
        }
    }

    /**
     * 手机验证码-登录
     */
    @GetMapping("/loginPhone")
    public AppResponse<Object> loginPhone(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        AppResponse<Object> resp;
        if (!StringUtils.isEmpty(phone)) {
            // 从Redis中获取账户的验证码
            String code_redis = stringRedisTemplate.opsForValue().get(phone + ":code");
            if (!StringUtils.isEmpty(code_redis)) {
                if (code_redis.equals(code)) {
                    UserRespVo respVo = new UserRespVo();
                    // 发送验证码的适合已经验证了邮箱是否存在
                    TUser userbyPhone = tUserService.getUserbyPhone(phone);
                    log.debug("登录成功-{}", phone);
                    // 生成token，UUID可能有-，要全部替换成空
                    String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
                    respVo.setAccessToken(accessToken);
                    //获取用户id
                    respVo.setUserId(userbyPhone.getUserId());
                    // 登录后将accessToken和用户id缓存到Redis,设置失效时间
                    stringRedisTemplate.opsForValue().set(accessToken, respVo.getUserId().toString(), 30, TimeUnit.MINUTES);
                    resp = AppResponse.ok(respVo);
                    resp.setMsg("登录成功");
                    return resp;
                } else {
                    log.debug("请重新输入验证码-{}", phone);
                    resp = AppResponse.fail(null);
                    resp.setMsg("请重新输入验证码");
                    return resp;
                }
            } else {
                log.debug("验证码失效-{}", phone);
                resp = AppResponse.fail(null);
                resp.setMsg("验证码已失效");
                return resp;
            }
        } else {
            log.debug("请输入邮箱-{}", phone);
            resp = AppResponse.fail(null);
            resp.setMsg("请输入邮箱");
            return resp;
        }
    }


    /**
     * 邮箱验证码-登录
     */
    @GetMapping("/loginEmail")
    public AppResponse<Object> loginEmail(@RequestParam("email") String email, @RequestParam("code") String code) {
        AppResponse<Object> resp;
        if (!StringUtils.isEmpty(email)) {
            // 从Redis中获取账户的验证码
            String code_redis = stringRedisTemplate.opsForValue().get(email + ":code");
            if (!StringUtils.isEmpty(code_redis)) {
                if (code_redis.equals(code)) {
                    UserRespVo respVo = new UserRespVo();
                    // 发送验证码的适合已经验证了邮箱是否存在
                    TUser userbyEmail = tUserService.getUserbyEmail(email);
                    log.debug("登录成功-{}", email);
                    // 生成token，UUID可能有-，要全部替换成空
                    String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
                    respVo.setAccessToken(accessToken);
                    //获取用户id
                    respVo.setUserId(userbyEmail.getUserId());
                    // 登录后将accessToken和用户id缓存到Redis,设置失效时间
                    stringRedisTemplate.opsForValue().set(accessToken, respVo.getUserId().toString(), 5, TimeUnit.MINUTES);
                    resp = AppResponse.ok(respVo);
                    resp.setMsg("登录成功");
                    return resp;
                } else {
                    log.debug("请重新输入验证码-{}", email);
                    resp = AppResponse.fail(null);
                    resp.setMsg("请重新输入验证码");
                    return resp;
                }
            } else {
                log.debug("验证码失效-{}", email);
                resp = AppResponse.fail(null);
                resp.setMsg("验证码已失效");
                return resp;
            }
        } else {
            log.debug("请输入邮箱-{}", email);
            resp = AppResponse.fail(null);
            resp.setMsg("请输入邮箱");
            return resp;
        }
    }


    /**
     * 用户注册
     * param 昵称、账户（邮箱or手机号）、密码、验证码
     * @PostMapping 只能与@RequestBody 一起用
     */
    @PostMapping("/reg")
    public AppResponse<Object> register(@RequestBody UserRegistVo vo) throws ParseException {
        String account = vo.getAccount();
        // 用spring提供的工具列就好了
        if (!StringUtils.isEmpty(account)) {
            // 从Redis中获取账户的验证码（失效就自己删除的)
            String code = stringRedisTemplate.opsForValue().get(account + ":code");
            // 创建UserRespVo接收数据
            UserRespVo respVo = new UserRespVo();
            // 再从vo中提取，开始对比用户输入的验证码
            if (!StringUtils.isEmpty(code)) {
                if (code.equals(vo.getCode())) {
                    if (!StringUtils.isEmpty(vo.getNickName())) {
                        // 1.昵称Nicker 唯一的
                        respVo.setUserNickName(vo.getNickName());
                        TUser tUserNicker = tUserService.getUserbyNicker(respVo.getUserNickName());
                        if (tUserNicker == null) {
                            // Bcrypt加密
                            String userpswd = vo.getUserpswd();
                            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                            // 2.设置密码
                            respVo.setUserPassword(encoder.encode(userpswd));
                            // 3.创建时间
                            respVo.setUserCreateTime(AppDateUtils.getDateTime());
                            // 4.用户状态 0正常1注销
                            respVo.setUserStatus("0");
                            // 5.用户类型 0管理员1普通用户
                            respVo.setUserType("1");

                            // 需要校验账户为手机号OR邮箱。
                            AppResponse<String> response = AccountORUtils.checkAccount(account);
                            // 邮箱注册
                            String emailStr = "email";
                            String phoneStr = "phone";
                            if (response.getData() == emailStr) {
                                respVo.setUserEmail(account);
                                // 需要校验账号是否唯一，返回1表示有数据
                                TUser acc = tUserService.getUserbyEmail(account);
                                if (acc != null) {
                                    AppResponse resp = AppResponse.fail(null);
                                    resp.setMsg("邮箱账户已经存在！");
                                    return resp;
                                }
                                // 手机号注册
                            } else if (response.getData() == phoneStr) {
                                respVo.setUserAccount(account);
                                // 需要校验账号是否唯一，返回1表示有数据
                                TUser acc = tUserService.getUserbyPhone(account);
                                if (acc != null) {
                                    AppResponse resp = AppResponse.fail(null);
                                    resp.setMsg("手机账户已经存在！");
                                    return resp;
                                }
                            } else {
                                AppResponse resp = AppResponse.fail(null);
                                resp.setMsg(response.getMsg());
                                return resp;
                            }
                            //  保存账户数据，user只差用户类型没设置
                            int sav = tUserService.saveUser(respVo);
                            if (sav == 1) {
                                // 清理用过的验证码
                                log.debug("开始清理验证码");
                                stringRedisTemplate.delete(account + ":code");
                                // 生成token，UUID可能有-，要全部替换成空
                                String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
                                respVo.setAccessToken(accessToken);
                                //获取用户id
                                TUser tUserId = tUserService.getUserbyNicker(respVo.getUserNickName());
                                respVo.setUserId(tUserId.getUserId());
                                // 登录后将accessToken和用户id缓存到Redis,设置失效时间
                                stringRedisTemplate.opsForValue().set(accessToken, respVo.getUserId().toString(), 30, TimeUnit.MINUTES);
                                AppResponse resp = AppResponse.ok(respVo);
                                resp.setMsg("注册成功！");
                                return resp;
                            } else {
                                AppResponse resp = AppResponse.fail(null);
                                resp.setMsg("注册失败！");
                                return resp;
                            }
                        } else {
                            AppResponse resp = AppResponse.fail(null);
                            resp.setMsg("昵称已经被占用！");
                            return resp;
                        }
                    } else {
                        AppResponse resp = AppResponse.fail(null);
                        resp.setMsg("请填写昵称！");
                        return resp;
                    }
                } else {
                    AppResponse resp = AppResponse.fail(null);
                    resp.setMsg("验证码不一致，请重新发送！");
                    return resp;
                }
            } else {
                AppResponse resp = AppResponse.fail(null);
                resp.setMsg("验证码已失效，请重新发送！");
                return resp;
            }
        } else {
            AppResponse resp = AppResponse.fail(null);
            resp.setMsg("用户账户不能为空！");
            return resp;
        }
    }

    /**
     * 发送短信验证码
     */
    @GetMapping("/sendSms")
    public AppResponse<Object> sendSms(@RequestParam("account") String account) {
        AppResponse resp;
        Long expire = stringRedisTemplate.getExpire(account + ":code");
        if (expire != -2){
            resp = AppResponse.fail(null);
            resp.setMsg("请"+expire.toString()+"秒后，再次发送验证码");
            return resp;
        }
        // 发短信验证码
        String code = HtmlEmailUtils.createCode();

        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", account);
        // 有效时间5分钟
        querys.put("param", "**code**:" + code + ",**minute**:2");
        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "908e94ccf08b4476ba6c876d13f084ad");

        smsTemplate.sendSms(querys);
        // 设置过期时间  Expire a 5  ，300秒后过期    ttl a  查看还有多少秒过期，-1表示永久，-2表示已过期，过期后自己会删除的
        stringRedisTemplate.opsForValue().set(account + ":code", code, 120, TimeUnit.SECONDS);

        log.debug("发送短信成功-验证码：{}", code);
        resp = AppResponse.ok("ok");
        resp.setMsg("发送短信验证证码成功");
        return resp;
    }

    /**
     * 注册时发送验证码
     *
     * @param account
     * @return
     */

    @GetMapping("/sendCode")
    public AppResponse<Object> sendCode(@RequestParam("account") String account) {
        try {
            // 需要校验账户为手机号OR邮箱。
            AppResponse<String> response = AccountORUtils.checkAccount(account);
            String emailStr = "email";
            String phoneStr = "phone";
            if (response.getData() == emailStr) {
                return sendEmailReg(account);
            } else if (response.getData() == phoneStr) {
                return sendSms(account);
            } else {
                AppResponse resp = AppResponse.fail(null);
                resp.setMsg(response.getMsg());
                return resp;
            }
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse resp = AppResponse.fail(null);
            resp.setMsg("邮箱服务器错误，请稍后再试");
            return resp;
        }
    }


    /**
     * 发送邮件注册验证码
     */
    @GetMapping("/sendEmailReg")
    public AppResponse<Object> sendEmailReg(@RequestParam("email") String email) {
        TUser userbyEmail = tUserService.getUserbyEmail(email);
        AppResponse resp;
       // String s = stringRedisTemplate.opsForValue().get(email + ":code");
        Long expire = stringRedisTemplate.getExpire(email + ":code");
        if (expire != -2){
            resp = AppResponse.fail(null);
            resp.setMsg("请"+expire.toString()+"秒后，再次发送验证码");
            return resp;
        }
        if (userbyEmail == null) {
            resp = HtmlEmailUtils.sendReg(email);
            String code = (String) resp.getData();

            resp.setMsg("发送注册验证码成功！");
            // 设置过期时间  Expire a 5  ，300秒后过期    ttl a  查看还有多少秒过期，-1表示永久，-2表示已过期
            stringRedisTemplate.opsForValue().set(email + ":code", code, 120, TimeUnit.SECONDS);
            log.debug("发送邮箱注册验证码成功-验证码：{}", code);
            return resp;
        } else {
            resp = AppResponse.fail(null);
            resp.setMsg("账户已存在!");
            return resp;
        }

    }

    /**
     * 发送邮件登录验证码
     *
     * @param email
     * @return
     */
    @GetMapping("/sendEmailLog")
    public AppResponse<Object> sendEmailLog(@RequestParam("email") String email) {
        TUser userbyEmail = tUserService.getUserbyEmail(email);
        String nickName = userbyEmail.getUserNickName();
        AppResponse resp;
        Long expire = stringRedisTemplate.getExpire(email + ":code");
        if (expire != -2){
            resp = AppResponse.fail(null);
            resp.setMsg("请"+expire.toString()+"秒后，再次发送验证码");
            return resp;
        }
        if (StringUtils.isEmpty(nickName)) {
            resp = AppResponse.fail(null);
            resp.setMsg("账户不存在");
            return resp;
        } else {
            resp = HtmlEmailUtils.sendLog(nickName, email);
            String code = (String) resp.getData();

            resp.setMsg("发送登录验证码成功！");
            // 设置过期时间  Expire a 5  ，300秒后过期    ttl a  查看还有多少秒过期，-1表示永久，-2表示已过期
            stringRedisTemplate.opsForValue().set(email + ":code", code, 120, TimeUnit.SECONDS);
            log.debug("发送邮箱登录验证码成功-验证码：{}", code);
            return resp;
        }
    }
}
