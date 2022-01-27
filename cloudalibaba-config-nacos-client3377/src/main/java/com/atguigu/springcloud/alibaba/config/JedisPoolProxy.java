package com.atguigu.springcloud.alibaba.config;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.util.Pool;

import java.lang.reflect.Method;

public class JedisPoolProxy implements MethodInterceptor {
    private Pool<Jedis> jedisPool;

    public JedisPoolProxy(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        try (Jedis jedis = jedisPool.getResource()) {
            if ("toString".equals(method.getName()) || "hashCode".equals(method.getName())) {
                return method.invoke(jedis, args);
            }
            return method.invoke(jedis, args);
        }
    }
}