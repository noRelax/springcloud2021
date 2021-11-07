package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wusong
 * @create 2020-12-27 6:26 下午
 **/

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentApi {
    @GetMapping("/get_payment")
    public CommonResult getById(@RequestParam("id") Long id) {
        log.info("请求数据ID:{}", id);
        Payment result = new Payment(1L, "支付100", "");
        return new CommonResult(200, "获取ID:" + id, result);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return new CommonResult(200, "入库成功！", payment);
    }

    @GetMapping("/getQQId")
    public CommonResult getQQId(HttpServletRequest request) {
        //获取端口号
        int port = request.getServerPort();
        return new CommonResult(200, "QQ端口号获取成功!", port);
    }


}
