package com.atguigu.springcloud.alibaba.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.util.Pool;

/**
 * @author wusong
 * @create 2022-01-27 20:39
 **/
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {
    @Bean
    public Pool<Jedis> jedisPool(@Autowired RedisProperties redisProperties) {
        Pool<Jedis> pool = new JedisPool(redisProperties.getHost(), redisProperties.getPort());
        return pool;
    }

    @Bean
    public Jedis jedis(@Autowired Pool<Jedis> jedisPool) {
        JedisPoolProxy proxy = new JedisPoolProxy(jedisPool);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Jedis.class);
        enhancer.setCallback(proxy);
        return (Jedis) enhancer.create();
    }
}
