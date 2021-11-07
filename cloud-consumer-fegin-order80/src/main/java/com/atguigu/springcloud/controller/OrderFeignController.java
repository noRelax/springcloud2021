package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wusong
 * @create 2021-11-07 3:29 下午
 **/
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/getById")
    public CommonResult getById() {
        return paymentFeignService.getById(1L);
    }

    @GetMapping("/getByQQId")
    public CommonResult getByQQId() {
        return paymentFeignService.getQQId();
    }

}
