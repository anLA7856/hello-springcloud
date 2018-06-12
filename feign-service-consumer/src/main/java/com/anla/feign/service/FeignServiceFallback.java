/**
 * @user junbao
 * @time 18-6-12 下午11:41
 */
package com.anla.feign.service;

import org.springframework.stereotype.Component;

/**
 * feign中的熔断降级配置，
 * 对应一个方法
 */
@Component
public class FeignServiceFallback implements FeignService {
    @Override
    public String hello() {
        return "hello error";
    }
}
