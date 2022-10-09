package com.yx.controller;

import com.yx.Strategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/22 09:56
 */
@RestController
@RequestMapping("/strategies")
@Api(value = "策略服务的Controller", tags = "Strategy")
public class StrategyController {

    @ApiOperation("测试hello")
    @GetMapping(path = "/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("测试api")
    @ApiImplicitParam(name = "name",value = "姓名", required = true, dataType = "String")
    @PostMapping(value = "/hi")
    public String hi(String name) {
        return "hi," + name;
    }

    @Value("${server.port}")
    private Integer Port;

    @RequestMapping("findById/{id}")
    public Strategy findById(@PathVariable String id) {
        System.out.println("id"+id);
        System.out.println("publish strategy success");
        return new Strategy(Port, "MACD", 30, 1, 1);
    }

    @PostMapping (value = "/save")
    public Map save(@RequestBody Strategy st) {
        System.out.println("调用策略参数配置文件");
        System.out.println(st);
        return new HashMap() {{
            put("isSuccess", true);
            put("msg", "save success");
        }};
    }

    @Value("${global.sys_path}")
    private String sys_path;

    @Value("${global.matrix}")
    private String matrix;

    @Value("${global.project_path}")
    private String project_path;

    @Value("${global.database}")
    private String database;

//    @Value("${global.tables}")
//    private String tables;

    @PostMapping (value = "/factor_research")
    public Map factor_research() {
        System.out.println("调用策略接口");
        System.out.println(sys_path);
        System.out.println(matrix);
        System.out.println(project_path);
        System.out.println(database);
        //System.out.println(tables);
        return new HashMap() {{
           put("isSuccess", true);
           put("msg", "save success");
        }};
    }

    @PostMapping(value = "/update")
    public Map update(@RequestBody Strategy st) {

        System.out.println(st);
        return new HashMap() {{
            put("isSuccess", true);
            put("msg", "update success");
        }};
    }

    @GetMapping(value = "/delete")
    public Map deleteById(Integer stId) {
        System.out.println("删除id为"+stId+"的策略");
        return new HashMap() {{
           put("isSuccess", true);
           put("msg", "delete success");
        }};
    }

    @GetMapping(value = "/{strategyid}")
    public Strategy findStrategyById(@PathVariable Integer strategyid) {
        System.out.println("已经查询到"+strategyid+"积分数据");
        return new Strategy(strategyid, "MACD", 30, 1, 1);
    }

    @PostMapping(value = "/searchByEntity")
    public List<Strategy> searchMap(@RequestBody Strategy st) {
        System.out.println(st);
        List<Strategy> strategiesList = new ArrayList<>();
        strategiesList.add(new Strategy(10, "MACD", 30, 2, 2));
        strategiesList.add(new Strategy(11, "MACD", 30, 1, 1));
        return strategiesList;

    }
}

