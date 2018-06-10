package com.anla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(HelloServiceApplication.class,args);
    }
}
