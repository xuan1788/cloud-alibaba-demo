package com.yx.mp;

import com.yx.mp.mapper.StockMapper;
import com.yx.mp.pojo.Stock;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/30 10:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMybatisSpringBoot {
    @Autowired
    private StockMapper stockMapper;
    
    @Test
    public void testSelect() {
        Stock stock = stockMapper.selectById(2);
        System.out.println(stock);
    }
}
