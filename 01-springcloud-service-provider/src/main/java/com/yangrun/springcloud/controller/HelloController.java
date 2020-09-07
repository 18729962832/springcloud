package com.yangrun.springcloud.controller;

import com.yangrun.springcloud.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    //@RequestMapping("/service/hello")     //能接收Get请求和POST请求
    @GetMapping("/service/hello")       //只能接收Get请求
    public String hello(){
        return "Hello,SpringCloud,provider 1";
    }

    @GetMapping("/service/user")       //只能接收Get请求
    public User user(){
        User user = new User();
        user.setId(110);
        user.setName("张三丰");
        user.setPhone("13800000000");
        return user;
    }

    @GetMapping("/service/getUser")       //只能接收Get请求
    public User getUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        return user;
    }

    //@RequestMapping(value = "/service/addUser",method = RequestMethod.POST)       //只能接收POST请求
    @PostMapping("/service/addUser")
    public User addUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        return user;
    }
}
