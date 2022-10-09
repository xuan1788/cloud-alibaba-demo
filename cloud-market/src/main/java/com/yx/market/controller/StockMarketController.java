package com.yx.market.controller;

import com.yx.mp.pojo.Stock;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/29 16:36
 */
@RestController
@RequestMapping("/stock_market")
public class StockMarketController {

    public Stock findByTradeDay(@PathVariable String day) {
        System.out.println("day"+day);
        return new Stock("000503", "国新健康",819687.30, 827380.27, 89877.99, 90721.52);
    }

}
