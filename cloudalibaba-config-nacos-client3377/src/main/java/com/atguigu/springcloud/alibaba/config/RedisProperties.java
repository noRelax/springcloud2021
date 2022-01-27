package com.atguigu.springcloud.alibaba.config;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * redis配置
 *
 * @author wusong
 * @create 2022-01-27 19:40
 **/
@Configuration
@Data
@RefreshScope
public class RedisProperties {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    /*@Value("${redis.name}")
    private String name;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.timeOut}")
    private Integer timeOut;*/
}
