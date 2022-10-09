package com.yx.order.controller;

import com.api.StraApi;
import com.yx.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/20 13:54
 */
@RestController
@RequestMapping("/order")
public class OrderController {


 /*   @RequestMapping("save")
    public Map save() {

        // 远程调用 cloud-goods 服务，获取goods信息，发送http请求（httpclient)=>resttemplate
        String serviceName = "cloud-strategies";
        String url = "http://"+serviceName+"/strategies/findById/1";
        val strategies = restTemplate.getForObject(url, Strategy.class);
        System.out.println(strategies);
        System.out.println("execute strategies success");
        return new HashMap() {{
            put("code", "200");
            put("msg", "success");
        }};
    }*/

    @Autowired
    private StraApi straApi;

    @RequestMapping("test1")
    public Map test1() {
        // 远程调用 strategies 服务的save接口
        Strategy stra = new Strategy(6, "MACD", 1, 1, 1);
        Map save = straApi.save(stra);
        return save;
    }

    @RequestMapping("test2")
    public Map test2() {
        Strategy stra = new Strategy(6, "MACD", 1, 1, 1);
        Map save = straApi.update(stra);
        return save;
    }

    @RequestMapping("test3")
    public Map test3() {
        Map deleteById = straApi.deleteById(1);

        return deleteById;
    }

    @RequestMapping("test4")
    public Strategy test4() {
        Strategy deleteById = straApi.findStrategyById(1);

        return deleteById;
    }

//    private ConfigData loadYml() throws FileNotFoundException {
//        String path = "/usr/Documents/Xuan_Data/cloud-demo/config.yml";
//        InputStream inputStream = new FileInputStream(path);
//        ConfigTreeConfigDataLoader yaml = null;
//        ConfigData map = yaml.load(inputStream);
//        return map;
//    }

    @RequestMapping("test5")
    public Map test5() {
        // 访问远端配置参数
        Map factor_research = straApi.factor_research();

        // 加载存放在本地（缓存中）的配置文件
//        ConfigData configData = loadYml();
//        Map factor_research = straApi.factor_research(configData);

        return factor_research;
    }

}
