package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wusong
 * @create 2021-11-07 9:20 下午
 **/
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerFeignHystrixOrderController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok")
    public String paymentHystrixOk(@RequestParam("id") Integer id) {
        String result = paymentHystrixService.paymentHystrixOk(id);
        log.info("paymentHystrixOk 请求ID:{},结果:{}", id, result);
        return result;

    }

    @GetMapping("/payment/hystrix/timeOut")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    public String paymentHystrixTimeOut(@RequestParam("id") Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = paymentHystrixService.paymentTimeOut(id);
        log.info("paymentHystrixTimeOut 请求ID:{},结果:{}", id, result);
        return result;

    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        log.info(">>>>>>>>>我是消费者80，对方支付系统繁忙，请10秒钟再试或者自己运行出错请检查自己");
        return ">>>>>>>>>我是消费者80，对方支付系统繁忙，请10秒钟再试或者自己运行出错请检查自己";
    }
}
