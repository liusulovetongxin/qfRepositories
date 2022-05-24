package com.qf.controller;

import com.qf.dto.R;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version V1.0
 * @Project MySSMdemo1
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/5/25 1:33
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public R add(@RequestBody User user){
        userService.addUser(user);
        return R.setOk();
    }
}
