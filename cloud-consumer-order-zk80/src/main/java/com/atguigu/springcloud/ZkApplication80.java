package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wusong
 * @date 2022年01月24日 15:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ZkApplication80.class, args);
    }
}
