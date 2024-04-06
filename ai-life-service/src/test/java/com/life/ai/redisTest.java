package com.life.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class redisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testRedisTemplate(){
        System.out.println(redisTemplate);
        ValueOperations valueOperations  = redisTemplate.opsForValue();
        HashOperations hashOperations = redisTemplate.opsForHash();
        ListOperations listOperations = redisTemplate.opsForList();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        SetOperations setOperations = redisTemplate.opsForSet();

    }
    @Test
    public void testRedisString(){
           redisTemplate.opsForValue().set("name","王",3, TimeUnit.MINUTES);
           redisTemplate.opsForValue().setIfAbsent("age",1);
           redisTemplate.opsForValue().setIfAbsent("age",2);
           redisTemplate.setKeySerializer(new StringRedisSerializer()); // 字符串序列化器
           redisTemplate.opsForHash().put(100,"name","dsa");
    }
}
