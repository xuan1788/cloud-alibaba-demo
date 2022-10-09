package com.yx.kline;

import com.yx.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/10/8 13:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Springboot211RedisApplicationTests {

    //@Autowired
    //private RedisTemplate<Object, User> userRedisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test01() {
        stringRedisTemplate.opsForValue().set("k1", "v1");
    }
    @Test
    public void test02(){
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("拿到{}", k1);
    }

//    @Test
//    void test03() {
//        User user = new User(1, "yang0", 3);
//        //使用jdk序列化机制将对象序列化 保存到redis中
//        //redisTemplate.opsForValue().set("user-01",user);
//
//        //一般我们都以json的方式保存数据
//        //1.可以使用json转换工具 fastjson jackson。
//        //2.自己将对象转化为json (使用这个)
//        //userRedisTemplate 改变默认的序列化规则
//        userRedisTemplate.opsForValue().set("user-02",user);
//    }
}
