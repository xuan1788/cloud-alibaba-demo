package com.yx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/20 10:19
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启服务的注册与发现
public class GoodsApp {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApp.class, args);
    }
}
