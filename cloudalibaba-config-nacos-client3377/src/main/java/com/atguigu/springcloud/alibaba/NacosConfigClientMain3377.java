package com.atguigu.springcloud.alibaba;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wusong
 * @create 2021-01-09 9:44 下午
 **/
@SpringBootApplication
@EnableDiscoveryClient
@NacosConfigurationProperties(dataId = "nacos-config-client-dev.yaml", autoRefreshed = true)
public class NacosConfigClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class, args);
    }
}
