package com.yx.strategy.controller;

import com.yx.Strategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
@Api(value = "策略服务的Controller", tags = "Strategy")
@RequestMapping("/strategies")
public class StrategyController {

    @ApiOperation("测试hello")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @ApiOperation("测试api")
    @ApiImplicitParam(name = "name",value = "姓名", required = true, dataType = "String")
    @RequestMapping(value = "/hi", method = RequestMethod.POST)
    public String hi(@RequestBody String name) {
        return "hi," + name;
    }

    @Value("${server.port}")
    private Integer Port;

    @ApiOperation(value = "获取策略详细信息", notes = "根据策略的id来获取单策略或策略组合详细信息")
    @ApiImplicitParam(name = "id", value = "策略ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public Strategy findById(@PathVariable Integer id) {
        System.out.println("id"+id);
        System.out.println("publish strategy success");
        return new Strategy(Port+id, "MACD", 30, 1, 1);
    }

    // 处理PUT请求，用来更新Strategy信息。
    @ApiOperation(value = "调用策略参数配置文件",notes = "根据url的id来指定更新对象，并根据传过来的strategy信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "策略ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "strategy", value = "详细strategy", required = true, dataType = "Strategy")
    })
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public Map save(@RequestBody Strategy st) {
        System.out.println("调用策略参数配置文件");
        System.out.println(st);
        System.out.println("strategy=="+st.getFactorName());
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

    @ApiOperation(value = "调用策略接口", notes = "查找因子对象的实例信息")
    @RequestMapping (value = "/factor_research", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sys_path", value = "策略路径", required = true, dataType = "String"),
            @ApiImplicitParam(name = "matrix", value = "策略详细实体strategy", required = true, dataType = "String")
    })
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

    @ApiOperation(value ="更新策略信息", notes = "根据策略id来指定更新对象，并根据传过来的strategy信息更新策略的具体信息")
    @RequestMapping(value = "/update")
    public Map update(@RequestBody Strategy st) {

        System.out.println(st);
        return new HashMap() {{
            put("isSuccess", true);
            put("msg", "update success");
        }};
    }

    @ApiOperation(value = "删除策略", notes ="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Map deleteById(@PathVariable Integer stId) {
        System.out.println("删除id为"+stId+"的策略");
        return new HashMap() {{
           put("isSuccess", true);
           put("msg", "delete success");
        }};
    }

    // url 中的id 可通过@PathVariable绑定到函数的参数中。
    @ApiOperation(value = "查询策略", notes = "根据策略的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "策略ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/{strategyid}", method = RequestMethod.GET)
    public Strategy findStrategyById(@PathVariable Integer strategyid) {
        System.out.println("已经查询到"+strategyid+"积分数据");
        return new Strategy(strategyid, "MACD", 30, 1, 1);
    }

    @ApiOperation(value = "获取策略池的关于某一策略的所有组合信息", notes = "返回包含某一策略的策略组合列表")
    @ApiImplicitParam(name = "strategy", value = "策略Entity", required = true, dataType = "Strategy")
    @RequestMapping(value = "/searchByEntity", method = RequestMethod.GET)
    public List<Strategy> searchMap(@RequestBody Strategy st) {
        System.out.println(st);
        List<Strategy> strategiesList = new ArrayList<>();
        strategiesList.add(new Strategy(10, "MACD", 30, 2, 2));
        strategiesList.add(new Strategy(11, "MACD", 30, 1, 1));
        return strategiesList;

    }
}

