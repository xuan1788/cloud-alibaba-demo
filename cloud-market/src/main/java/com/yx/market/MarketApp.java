package com.yx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/29 15:55
 */
@MapperScan("com.yx.mp.mapper") // 设置mapper接口的扫描包
@SpringBootApplication
public class MarketApp {
    public static void main(String[] args) {
        SpringApplication.run(MarketApp.class, args);
    }
}
