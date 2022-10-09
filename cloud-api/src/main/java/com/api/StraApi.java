package com.api;

import com.yx.Strategy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/23 11:11
 */
@FeignClient("cloud-strategies")
@RequestMapping("strategies")
public class StraApp {
    @RequestMapping(value = "/save")
    public Map save(@RequestBody Strategy st);

}
