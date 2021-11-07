package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单api
 *
 * @author wusong
 * @create 2020-12-27 7:15 下午
 **/
@RestController
@Api(tags = "订单管理")
public class OrderApi {
    @Autowired
    private RestTemplate restTemplate;
    //public static final String PAYMENT_URL = "http://localhost:8001";

    //集群负载均衡
    //● provider 的微服务名称必须使用同一个名称才能构成一个集群，否则将不会认定为是属于同一个集群。
    //● 然后consumer每次调用provider的controller时 就有了负载均衡
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


    @ApiOperation(value = "获取订单详情")
    @ApiImplicitParam(name = "id", paramType = "long", value = "订单ID")
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get_payment?id=" + id, CommonResult.class);
    }

    @ApiOperation(value = "获取用户详情")
    @ApiImplicitParam(name = "id", type = "long", value = "用户ID")
    @GetMapping("/consumer/getUserInfo")
    public CommonResult<UserVO> getUserInfo(@RequestParam("id") Long id) {
        UserVO userVO = new UserVO("wusong", 22, new Payment());
        return new CommonResult(200, "OK", userVO);

    }

    @GetMapping("/consumer/getQQId")
    public CommonResult getQQId() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getQQId", CommonResult.class);
    }

    @Data
    @AllArgsConstructor
    class UserVO {
        String name;
        Integer age;
        Payment payment;
    }
}
