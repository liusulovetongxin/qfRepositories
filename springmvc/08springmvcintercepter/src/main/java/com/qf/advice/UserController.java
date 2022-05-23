package com.qf.advice;

import com.qf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.advice
 * @Description:
 * @Date 2022/5/23 20:17
 */
@Controller
public class UserController {


    @RequestMapping("/user/info")
    public User findByName(String name) {

        User user = new User();
        user.setName(name);
        user.setAddress("北京市昌平区沙阳路xxx号xxx小区");
        user.setAge(40);
        user.setGender("nan");
        return user;
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        System.err.println("UserController中的方法login 执行了");
        session.setAttribute("user", "dasdas");
        return "login success";
    }
}
