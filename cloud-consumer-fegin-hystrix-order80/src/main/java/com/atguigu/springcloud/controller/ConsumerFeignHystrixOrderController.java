package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        log.info("请求ID:{},结果:{}", id, result);
        return result;

    }
}
