package com.yx.strategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/22 10:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StrategiesApp {
    public static void main(String[] args) {
        SpringApplication.run(StrategiesApp.class, args);
    }
}
