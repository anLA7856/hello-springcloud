/**
 * @user junbao
 * @time 18-6-20 下午11:14
 */
package com.anla.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/")
@Controller
public class ApiController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        ServiceInstance config = client.getLocalServiceInstance();
        String result = "/hello-service:"+config.getHost() +"--------service_id:"+config.getServiceId();
        logger.info(result);
        return "hello-service,result is"+result;
    }
}
