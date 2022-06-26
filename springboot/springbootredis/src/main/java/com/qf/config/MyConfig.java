package com.qf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootredis
 * @Package com.qf.config
 * @Description:
 * @Date 2022/6/17 11:43
 */
@Configuration
public class MyConfig {
    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    public void configRedisTemplate(){
// StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //设置key 的序列化方式,如果不设置就是默认的jdk的序列化方式
        // redisTemplate.setKeySerializer(stringRedisSerializer);
        //设置value的序列化方式,如果不设置就是默认的jdk的序列化方式
        //   redisTemplate.setValueSerializer(stringRedisSerializer);
        //设置hash的key和value的序列化方式
        // redisTemplate.setHashKeySerializer();
        // redisTemplate.setHashValueSerializer();

        //jackieson格式的序列化方式,可以将数据转成json,生成的json中包含一个key @class,声明了当前数据的类型
//        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
//        redisTemplate.setKeySerializer(genericJackson2JsonRedisSerializer);
//        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);

        //这个序列化方式就是单纯的转换为json,保存起来
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    }
}
