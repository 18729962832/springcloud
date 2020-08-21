package com.yangrun.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //等价于Spring里的applicationContext.xml文件
public class BeanConfig {

    /**
     * @Bean 就等价于：
     *
     * <bean id="restTemplate",class="com.yangrun.springcloud.config.BeanConfig.restTemplate">
     *
     * </bean>
     *
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
