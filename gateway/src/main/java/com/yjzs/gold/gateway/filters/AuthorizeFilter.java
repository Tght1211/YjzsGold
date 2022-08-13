package com.yjzs.gold.gateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Tght
 * @Order(-1) 越小优先级越高
 * @Component
 */

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Autowired
    StringRedisTemplate redisTemplate;

    private static AntPathMatcher matcher = new AntPathMatcher();

    public static boolean needLogin(String uri){
        // test
        List<String> uriList = new ArrayList<>();
        uriList.add("/start/**");
        uriList.add("/com/posts/editor");

        for (String pattern : uriList) {
            if (matcher.match(pattern, uri)) {
                System.out.println("uri="+uri);
                // 不需要拦截
                return true;
            }
        }
        return false;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1.获取请求参数
        ServerHttpRequest request = exchange.getRequest();

        // 不需要拦截的url直接放行
        if(needLogin(request.getPath().toString())){

            return chain.filter(exchange);
        }else {
            HttpHeaders headers = request.getHeaders();
            //2.获取请求头中的 token 参数
            String token = headers.getFirst("token");
            // 3.判断token是否等于 redis中的token
            if (token != null && redisTemplate.opsForValue().get(token) != null) {
                // 每次请求就修改过期时间
                redisTemplate.expire(token, 30, TimeUnit.MINUTES);
                // 4.是，放行
                return chain.filter(exchange);
            }
            System.out.println("登录过期了");
            // 5.否，拦截
            // 5.1.设置状态码  响应状态401，表示未登录
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            // 5.2.拦截请求
            return exchange.getResponse().setComplete();
        }
    }

    /**
     * 在这里写-1和@order一样的,这里表示优先级
     * @return
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
