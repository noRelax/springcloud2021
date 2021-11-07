package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wusong
 * @create 2021-11-07 8:36 下午
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class HystrixPaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("请求参数:{}结果:{}", id, result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String timeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("请求参数:{}结果:{}", id, result);
        return result;
    }

}