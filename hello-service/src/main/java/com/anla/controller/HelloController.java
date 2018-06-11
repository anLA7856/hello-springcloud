/**
 * @user junbao
 * @time 18-6-9 下午4:04
 */
package com.anla.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance config = client.getInstances("localhost").get(0);
        logger.info("/hello-service:"+config.getHost() +"--------service_id:"+config.getServiceId());
        return "hello-service";
    }

    /**
     * 用于负载均衡访问配置
     * @param name
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String index(@RequestParam String name){
        ServiceInstance config = client.getLocalServiceInstance();
        String serviceId = config.getServiceId();
        String result = "hello: I am "+serviceId+", ribbon test"+name;
        logger.info(result);
        return result;
    }

    @RequestMapping(value = "/hystrix",method = RequestMethod.GET)
    public String tell(@RequestParam String name) throws InterruptedException {
        Integer num = (int)Math.random()*128;
        if(num%2 == 1){
            Thread.sleep(5000);
        }
        ServiceInstance config = client.getLocalServiceInstance();
        String serviceId = config.getServiceId();
        String result = "hello: I am "+serviceId+", hystrix test:"+name;
        logger.info(result);
        return result;
    }

}
