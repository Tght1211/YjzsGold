package com.yjzs.gold.feign.clients;

import com.yjzs.gold.feign.bean.TUser;
import com.yjzs.gold.feign.clients.exphandler.TUserClientExceptionHandler;
import com.yjzs.gold.utils.AppResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Tght
 * Feign接口，代替Service，内包含对应服务的controller请求路径
 *  value表示这个接口在哪个服务里，它去找。
 */
@FeignClient(value = "YJZS-USER",fallback = TUserClientExceptionHandler.class)
public interface TUserClient {


    /**
     * user中根据id获取用户接口
     * @param id
     * @return
     */
    @GetMapping("/user/my/select")
    public AppResponse<TUser> selectUser(@RequestParam("id") String id);
}
