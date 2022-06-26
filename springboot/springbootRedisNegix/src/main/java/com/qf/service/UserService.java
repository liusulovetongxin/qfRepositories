package com.qf.service;

import com.qf.pojo.User;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootRedisNegix
 * @Package com.qf.service
 * @Description:
 * @Date 2022/6/18 13:49
 */

public interface UserService {
    void addRedis(User user);

    Object getUser(String username);

    void logout(String username);
}
