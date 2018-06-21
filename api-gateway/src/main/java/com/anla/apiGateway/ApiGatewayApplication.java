/**
 * @user junbao
 * @time 18-6-20 下午11:01
 */
package com.anla.apiGateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy                //开启api网关服务
@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
    }
}
