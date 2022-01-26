package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wusong
 * @create 2021-11-07 8:38 下午
 **/
@Service
@Slf4j
public class PaymentService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 正常访问，肯定ok
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " PaymenyInfo_OK,id: " + id + "\t " + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfo_TimeOut(Integer id) {

        int timeNumber = 5000;
        //int timeNumber = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " PaymenyInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~" + " 耗时" + timeNumber + "毫秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " 8001系统繁忙系统报错paymentInfo_TimeOutHandler ,请稍后再试id: " + id + "\t " + "o(╥﹏╥)o";

    }

    /**
     * 服务的降级->进而熔断->恢复调用链路
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "1"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "服务异常，请稍后再试，o(╥﹏╥)o id：" + id;
    }

    /**
     * 获取redis count
     *
     * @return
     */
    public String getCount() {
//        //调用lua脚本并执行
//        DefaultRedisScript<List> redisScript = new DefaultRedisScript<>();
//        redisScript.setResultType(List.class);//返回类型是String
//        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/list.lua")));
//        Object result = redisTemplate.execute(redisScript, Arrays.asList("name"));
//        log.info(">>>>>>>>>>>redis lua return:{}", result);
//        return result.toString();
        Long result = 0L;
        try {
            //调用lua脚本并执行
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
            redisScript.setResultType(Long.class);//返回类型是Long
            //lua文件存放在resources目录下的redis文件夹内
            redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/list.lua")));
            result = (Long) redisTemplate.execute(redisScript, Arrays.asList("prize_stock"), 100, 300);
            System.out.println("lock==" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
