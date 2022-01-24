package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wusong
 * @date 2022年01月24日 16:08
 */
@RestController
@Slf4j
public class OrderConsumerZkController {
    public static final String invoke_url = "http://cloud-provider-zookeeper-payment8003";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(invoke_url+"/payment/zk", String.class);
        return result;
    }
}
