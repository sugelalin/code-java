package org.example.practice.consumer.config;

import org.example.practice.consumer.feignclient.Provider1UserClient;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 当Feign接口调用失败时会调用指定fallback实现类
 *
 * fallback 是通过 Hystrix 实现的，所以需要开启 Hystrix，即 feign.hystrix.enabled=true
 *
 * 缺点：获取不到http请求的错误码和信息
 */
@Component
@Slf4j
public class Provider1UserFeignFallBack implements Provider1UserClient {

    private static final String FALLBACK_PREFIX = "fallback-";

    @Override
    public String hello() {
        return FALLBACK_PREFIX + "hello";
    }
}
