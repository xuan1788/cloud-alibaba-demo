package com.rule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/23 16:01
 */
@Configuration
public class MyRule {

    @Bean
    public IRule getRule() { return new BestAvailableRule(); }
}
