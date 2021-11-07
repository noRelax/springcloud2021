package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wusong
 * @create 2020-12-27 7:23 下午
 **/
@Service
public class BeanConfig {
    @Bean
    //在配置类中的restTemplate添加@LoadBalanced注解 这个注解会 给这个组件 有负载均衡的功能
    //当请求URL使用http://CLOUD-PAYMENT-SERVICE时会生效
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
