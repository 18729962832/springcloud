package com.yangrun.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
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
    @LoadBalanced   //使用Ribbon实现了负载均衡的调用
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 覆盖掉原来Ribbon磨人的负载均衡策略
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();    //采用随机的负载均衡策略
    }
}
