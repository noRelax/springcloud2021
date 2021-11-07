package com.atguigu.springcloud.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wusong
 * @create 2020-12-27 6:36 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @ApiModelProperty(value = "支付ID",example = "1234")
    private Long id;
    @ApiModelProperty("序列号")
    private String serial;
    @ApiModelProperty(value = "订单创建时间",notes = "created_at")
    private String createdAt;
}
