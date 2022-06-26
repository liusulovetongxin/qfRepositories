package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootRedisNegix
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/6/18 13:49
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void addRedis(User user) {
//        System.err.println("运行到了？？");
        Assert.isTrue(!user.isEmpty(), ()->{
//            System.err.println("出错");
            throw new RuntimeException();

        });
        Object redisUser = redisTemplate.opsForValue().get(user.getUsername());
        if (redisUser != null) {
            System.err.println(redisUser);
        }else{
            User userdata = userMapper.findByUsername(user.getUsername());
            Assert.notNull(userdata, ()->{
                throw new RuntimeException("错误");
            });
            Assert.isTrue(user.getPassword().equalsIgnoreCase(userdata.getPassword()), ()->{
                throw new RuntimeException("用户名或密码错误");
            });
            redisTemplate.opsForValue().set(user.getUsername(), user);
        }
    }

    @Override
    public Object getUser(String username) {
        Object userRedis = redisTemplate.opsForValue().get(username);
        Assert.notNull(userRedis,()->{
            throw new RuntimeException("未登录");
        });
        return userRedis;
    }

    @Override
    public void logout(String username) {
            Boolean delete = redisTemplate.delete(username);
            Assert.isTrue(delete, ()->{
                throw new RuntimeException("未登录");
            });
    }
}
