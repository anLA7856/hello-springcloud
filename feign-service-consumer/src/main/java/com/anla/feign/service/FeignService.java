/**
 * @user junbao
 * @time 18-6-12 下午10:57
 */
package com.anla.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="hello-service",fallback = FeignServiceFallback.class)
public interface FeignService {

    @RequestMapping("/hello")
    String hello();
}
