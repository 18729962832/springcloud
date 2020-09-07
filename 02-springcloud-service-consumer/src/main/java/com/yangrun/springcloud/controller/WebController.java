package com.yangrun.springcloud.controller;

import com.yangrun.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello(){

        //调用SpringCloud服务提供者提供的服务
        ResponseEntity<String> responseEntity =  restTemplate.getForEntity("http://01-springcloud-service-provider/service/hello",String.class);
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        String body = responseEntity.getBody();

        System.out.println(statusCodeValue);
        System.out.println(httpStatus);
        System.out.println(httpHeaders);
        System.out.println(body);

        //使用Robbin之后可以直接用服务名称进行访问
        return restTemplate.getForEntity("http://01-springcloud-service-provider/service/hello",String.class).getBody();
    }

    @RequestMapping("/web/user")
    public String user(){

        //调用SpringCloud服务提供者提供的服务
        ResponseEntity<User> responseEntity =  restTemplate.getForEntity("http://01-springcloud-service-provider/service/user",User.class);
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        User body = responseEntity.getBody();

        System.out.println(statusCodeValue);
        System.out.println(httpStatus);
        System.out.println(httpHeaders);
        System.out.println(body);

        //使用Robbin之后可以直接用服务名称进行访问
        return restTemplate.getForEntity("http://01-springcloud-service-provider/service/user",String.class).getBody();
    }

    @RequestMapping("/web/getUser")
    public User getUser(){

        String[] strArrays = {"111","张无忌","13100000000"};
        //调用SpringCloud服务提供者提供的服务
        ResponseEntity<User> responseEntity =  restTemplate.getForEntity("http://01-springcloud-service-provider/service/getUser?id={0}&name={1}&phone={2}",User.class,strArrays);
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        User body = responseEntity.getBody();

        System.out.println(statusCodeValue);
        System.out.println(httpStatus);
        System.out.println(httpHeaders);
        System.out.println(body);

        //使用Robbin之后可以直接用服务名称进行访问
        return restTemplate.getForEntity("http://01-springcloud-service-provider/service/getUser?id={0}&name={1}&phone={2}",User.class,strArrays).getBody();
    }

    @RequestMapping("/web/addUser")
    public User addUser(){

        String[] strArrays = {"111","张无忌","13100000000"};

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("id",1028);
        map.put("name","张翠山");
        map.put("phone","13700000000");

        //要传的表单信息，参数数据
        MultiValueMap<String,Object> dataMap = new LinkedMultiValueMap<String,Object>();
        dataMap.add("id",1028);
        dataMap.add("name","张翠山");
        dataMap.add("phone","13700000000");

        //调用SpringCloud服务提供者提供的服务
        ResponseEntity<User> responseEntity =  restTemplate.postForEntity("http://01-springcloud-service-provider/service/addUser",dataMap,User.class);


        //使用Robbin之后可以直接用服务名称进行访问
        return restTemplate.postForEntity("http://01-springcloud-service-provider/service/addUser?id={0}&name={1}&phone={2}",dataMap,User.class).getBody();
    }
}
