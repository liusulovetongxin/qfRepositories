package com.qf.controller;

import com.qf.pojo.User;
import com.qf.result.R;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootRedisNegix
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/6/18 13:48
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(User user){
        System.err.println(user);
        return "success";
    }
    @PostMapping("/login")
    public R login(User user){
        try {
            userService.addRedis(user);
        } catch (Exception e) {
            return R.setError(e.getMessage());
        }
        System.err.println(user);
        return R.setOk();
    }
    @GetMapping("/user/{username}")
    public R getUser(@PathVariable String username){
        Object user = null;
        try {
            user = userService.getUser(username);
        } catch (Exception e) {
            return R.setError(e.getMessage());
        }
        return R.setOk(user);
    }
    @GetMapping("/logout/{username}")
    public R logout(@PathVariable String username){
        try {
            userService.logout(username);
        } catch (Exception e) {
            return R.setError(e.getMessage());
        }
        return R.setOk();
    }
}
