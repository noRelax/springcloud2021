package com.atguigu.springcloud.alibaba.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.springcloud.alibaba.config.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    /*@Autowired
    private RedisProperties orderProperties;

    *//**
     * 测试 @ConfigurationProperties 注解的配置属性类
     *//*
    @GetMapping("/test01")
    public String test01() {
        return JSONUtil.toJsonStr(orderProperties);
    }*/

    @Value(value = "${redis.host}") // @NacosValue(value = "${order.pay-timeout-seconds}")
    private String redisHost;
    @Value(value = "${redis.port}") // @NacosValue(value = "${order.create-frequency-seconds}")
    private Integer redisPort;

    /**
     * 测试 @Value 注解的属性
     */
    @GetMapping("/test02")
    public Map<String, Object> test02() {
        return new JSONObject().fluentPut("payTimeoutSeconds", redisHost)
                .fluentPut("createFrequencySeconds", redisPort);
    }

}