package com.yjzs.gold.feign.clients.exphandler;

import com.yjzs.gold.feign.bean.TUser;
import com.yjzs.gold.feign.clients.TUserClient;
import com.yjzs.gold.utils.AppResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Tght
 */
@Slf4j
@Component
public class TUserClientExceptionHandler implements TUserClient {

    @Override
    public AppResponse<TUser> selectUser(String id) {

        AppResponse<TUser> resp = AppResponse.fail(null);
        resp.setMsg("远程调用服务【根据id获取用户信息】失败");
        log.debug("远程调用服务【根据id获取用户信息】失败");
        return resp;
    }
}
