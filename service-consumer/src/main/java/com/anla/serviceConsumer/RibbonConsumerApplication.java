/**
 * @user junbao
 * @time 18-6-10 下午11:03
 */
package com.anla.serviceConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ribbon客户端的启动类
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(RibbonConsumerApplication.class,args);
    }


}
