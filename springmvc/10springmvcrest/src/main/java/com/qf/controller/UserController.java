package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/5/23 20:46
 */

//@CrossOrigin("http://localhost:8080")
@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //这两那个注解的效果是一样的
//    @RequestMapping(method = RequestMethod.GET )
    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id) {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("大叔大婶大");
        user.setBirthday(new Date());
        user.setAge(18);
        user.setGender("男");
        return user;
    }

    @DeleteMapping("/user/{id}")
    public String deleteByID(@PathVariable Long id) {
        System.err.println(id);
        return "delete success";
    }

    @PutMapping("/user")
    public String addUser(User user) {
        System.err.println(user);
        return "add success";
    }


    @PostMapping("/user")
    public String updateUser(User user) {
        System.err.println(user);
        return "update success";
    }
}
