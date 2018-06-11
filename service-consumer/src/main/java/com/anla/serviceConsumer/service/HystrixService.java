/**
 * @user junbao
 * @time 18-6-11 下午8:41
 */
package com.anla.serviceConsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public String hystrixService(String name){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://hello-service/hystrix?name={1}",String.class,name+":test anla");
        String body = responseEntity.getBody();
        return body;
    }

    public String hystrixFallback(String name){
        return "arg is "+name+",sorry,service is busy, please wait a moment and try again.";
    }
}
