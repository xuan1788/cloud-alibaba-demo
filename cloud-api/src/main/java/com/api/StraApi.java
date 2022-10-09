package com.api;

import com.yx.Strategy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/23 11:11
 */
@FeignClient("cloud-strategies")
@RequestMapping("/strategies")
public interface StraApi {
    @PostMapping(value = "/save")
    public Map save(@RequestBody Strategy st) ;

    @PostMapping(value = "/update")
    public Map update(@RequestBody Strategy st);

    @GetMapping(value = "/delete")
    public Map deleteById(@RequestParam("strategyid") Integer stId);

    @GetMapping(value = "/{strategyid}")
    public Strategy findStrategyById(@PathVariable Integer strategyid);

    @PostMapping(value = "/searchByEntity")
    public List<Strategy> searchMap(@RequestBody Strategy st);

    @PostMapping (value = "/factor_research")
    public Map factor_research();
}
