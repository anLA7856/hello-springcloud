/**
 * @user junbao
 * @time 18-6-10 下午11:08
 */
package com.anla.serviceConsumer.controller;

import com.anla.serviceConsumer.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HystrixService hystrixService;

    /**
     * 用于测试ribbon负载均衡
     * @param name
     * @return
     */
    @GetMapping(value = "/ribbon/{name}")
    public String findInfoById(@PathVariable String name){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://hello-service/user?name={1}",String.class,name+":test anla");
        String body = responseEntity.getBody();
        return body;
    }

    /**
     * 用于测试hystrix熔断降级,
     * time-out时间为3s
     * @param name
     * @return
     */
    @GetMapping(value="hystrix/{name}")
    public String getMessageByName(@PathVariable String name){
        return hystrixService.hystrixService(name);
    }


}
