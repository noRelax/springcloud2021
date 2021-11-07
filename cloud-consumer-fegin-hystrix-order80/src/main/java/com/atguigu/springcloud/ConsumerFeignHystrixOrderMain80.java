package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wusong
 * @create 2021-11-07 9:22 下午
 **/
@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
public class ConsumerFeignHystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrixOrderMain80.class, args);
    }
}
