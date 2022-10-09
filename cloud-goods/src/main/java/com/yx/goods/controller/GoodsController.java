package com.yx.goods.controller;

import com.yx.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/20 13:35
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    @Value("${server.port}")
    private String Port;
    @RequestMapping("findById/{id}")
    public Goods findById(@PathVariable String id) {

        System.out.println("id"+id);
        return new Goods("小米"+Port,99);
    }
}
