package com.atguigu.springcloud.service;

/**
 * @author wusong
 * @date 2021年11月12日 15:39
 */

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService {

    @Override
    public CommonResult getPayment(Long id) {
        return new CommonResult(500, "接口处理失败！");
    }

    @Override
    public CommonResult getQQId() {
        return null;
    }

    @Override
    public CommonResult getById(Long id) {
        return null;
    }

    @Override
    public Object scNotify(String tableName, String id, String token) {
        return "调用数仓接口失败";
    }
}
