/**
 * @user junbao
 * @time 18-6-21 下午11:40
 */
package com.anla.ssoClient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
