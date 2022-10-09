package com.yx.kline;

import com.yx.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/10/8 11:21
 */
public class MyRedisConfig {
    @Bean
    public RedisTemplate<Object, User> redisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ){
        RedisTemplate<Object, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User> ser = new Jackson2JsonRedisSerializer<User>(User.class);
        redisTemplate.setDefaultSerializer(ser);
        return redisTemplate;
    }
}
