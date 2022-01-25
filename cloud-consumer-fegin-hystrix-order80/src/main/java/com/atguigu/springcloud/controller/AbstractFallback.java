package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常降级处理类
 *
 * @author wusong
 * @date 2022年01月25日 16:18
 */
@Slf4j
public abstract class AbstractFallback {
    public String globalFallbackMethod() {
        log.info("Global异常处理信息，请稍后再试，o(╥﹏╥)o");
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }
}
