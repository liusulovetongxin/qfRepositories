package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootredis
 * @Package controller
 * @Description:
 * @Date 2022/6/17 11:30
 */
@RestController
public class TetController {
    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("/get")
    public String get(String key){

        return stringRedisTemplate.opsForValue().get(key);
    }
    @PostMapping("/set")
    public String set(String key,String value){
        stringRedisTemplate.opsForValue().set(key, value);
        return "success";
    }
    @PostMapping("setJson")
    public String setJson(String key){
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        redisTemplate.opsForValue().set(key, user);
        return "success";
    }


    @GetMapping("/getJson")
    public Object getJson(String key){
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/pipe1")
    public String pipe1(){
        List list =redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                long start =System.currentTimeMillis();
                redisConnection.openPipeline();
                for (int i = 0; i < 10000; i++) {
                    redisConnection.stringCommands().set(("springbootdata"+i).getBytes(StandardCharsets.UTF_8), ("value"+i).getBytes());
                }
                redisConnection.close();
                long end = System.currentTimeMillis();
                System.err.println(end-start);
                return null;
            }
        });
//        System.err.println(list);
        return "success";
    }
}

