package com.yangrun.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello(){

        //调用SpringCloud服务提供者提供的服务
        //return restTemplate.getForEntity("http://localhost:8080/service/hello",String.class).getBody();

        //使用Robbin之后可以直接用服务名称进行访问
        return restTemplate.getForEntity("http://01-springcloud-service-provider/service/hello",String.class).getBody();
    }
}
