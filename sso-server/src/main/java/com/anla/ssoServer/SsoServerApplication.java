/**
 * @user junbao
 * @time 18-6-21 下午10:16
 */
package com.anla.ssoServer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SsoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoServerApplication.class, args);
    }
}
