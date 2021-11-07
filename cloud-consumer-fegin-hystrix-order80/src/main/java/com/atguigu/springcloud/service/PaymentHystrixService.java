package com.atguigu.springcloud.service;

import io.swagger.models.auth.In;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wusong
 * @create 2021-11-07 9:25 下午
 **/
@Component
@FeignClient(value = "provider-hystrix-payment8001",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentHystrixOk(@PathVariable("id") Integer id);
}
