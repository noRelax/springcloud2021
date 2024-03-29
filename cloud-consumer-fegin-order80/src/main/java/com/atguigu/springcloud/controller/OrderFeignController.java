package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/get_payment")
    public CommonResult getPayment() {
        return paymentFeignService.getPayment(1L);
    }

    @GetMapping("/getById")
    public CommonResult getById() {
        return paymentFeignService.getById(1L);
    }

    @GetMapping("/getByQQId")
    public CommonResult getByQQId() {
        return paymentFeignService.getQQId();
    }

    @GetMapping("/sc_notify")
    public Object scNotify(@RequestParam("tableName") String tableName, @RequestParam("id") String id, @RequestParam("token") String token) {
        return paymentFeignService.scNotify(tableName, id, token);
    }

}
