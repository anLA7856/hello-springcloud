/**
 * @user junbao
 * @time 18-6-12 下午11:02
 */
package com.anla.feign.controller;

import com.anla.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "feign-consumer",method = RequestMethod.GET)
    public String helloFeign(){
        return feignService.hello();
    }
}
