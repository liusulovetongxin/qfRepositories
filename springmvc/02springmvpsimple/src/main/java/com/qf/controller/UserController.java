package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/5/20 10:39
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @RequestMapping("/user1")
    public String user1(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.err.println("UserController类中的user1方法执行了-->"+username+" and "+password);
        return "forward:/index";
    }

    @RequestMapping("/user2")
    public String user2(@RequestParam(name = "username")String username,@RequestParam("password")String password){
        System.err.println("UserController类中的user2方法执行了-->"+username+" "+password);
        return null;
    }

    @RequestMapping("/user3")
    public String user3(User user){
        System.err.println("UserController类中的user3方法执行了-->"+user.toString());
        return null;
    }

    @RequestMapping("/user4/{id}/{name}")
    public String user4(@PathVariable("id")Long id,@PathVariable("name")String name){
        System.err.println("UserController类中的user4方法执行了-->"+id+"  "+name);
        return null;
    }
}
