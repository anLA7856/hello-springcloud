/**
 * @user junbao
 * @time 18-6-21 下午10:38
 */
package com.anla.ssoClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;


@SpringBootApplication
public class SsoClientApplication {
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(SsoClientApplication.class, args);
    }
}
