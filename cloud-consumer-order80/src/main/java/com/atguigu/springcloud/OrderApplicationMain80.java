package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wusong
 * @create 2020-12-27 7:35 下午
 **/
@SpringBootApplication
@EnableEurekaClient
public class OrderApplicationMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationMain80.class, args);
    }
}
