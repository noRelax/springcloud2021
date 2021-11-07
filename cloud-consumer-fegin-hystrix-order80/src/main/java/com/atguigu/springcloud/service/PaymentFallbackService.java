package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Yang Hao
 * @description
 * @date 2020-09-16 16:38
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentHystrixOk(Integer id) {
        return "-------PaymentFallbackService fall back-[paymentInfo_OK],o(╥﹏╥)o";
    }
}
