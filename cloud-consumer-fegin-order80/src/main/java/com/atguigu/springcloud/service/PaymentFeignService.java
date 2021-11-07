package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wusong
 * @create 2021-11-07 3:35 下午
 **/
@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    /**
     * 远程调用的接口方法：
     * 1.要求@RequestMapping注解映射的地址一致
     * 2.要求方法声明一致
     * 3.用来获取请求参数
     *
     * @return
     * @RequestParam @PathVariable @RequestBody @RequestParam  不能省略，两边一致
     */
    @GetMapping("/payment/getQQId")
    CommonResult getQQId();

    @GetMapping("/payment/get_payment")
    CommonResult getById(@RequestParam("id")Long id);

}
