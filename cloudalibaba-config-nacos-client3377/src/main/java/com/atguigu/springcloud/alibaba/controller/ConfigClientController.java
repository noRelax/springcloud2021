package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.springcloud.alibaba.config.RedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.util.Pool;

/**
 * @author wusong
 * @create 2021-01-09 9:46 下午
 **/
@RestController
@RefreshScope
@Slf4j
public class ConfigClientController {
    @Value("${config.info}")
    public String configInfo;
    @Autowired
    private Jedis jedis;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        log.info(">>>>>>>" + jedis.get("name"));
        return configInfo;
    }
}
