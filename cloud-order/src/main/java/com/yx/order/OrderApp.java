package com.yx;

import com.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/20 13:51
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "cloud-strategies", configuration = {MyRule.class})
@EnableFeignClients(basePackages = {"com.api"}) //开启openfeign
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

}
