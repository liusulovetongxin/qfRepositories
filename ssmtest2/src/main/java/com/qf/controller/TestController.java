package com.qf.controller;

import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project ssmtest2
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/5/22 16:34
 */
@Controller
@RequestMapping("/user")
public class TestController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user1")
    public String user1(HttpServletRequest request){
        List<TbUser> list = userService.findAll();
        request.setAttribute("list", list);
        return "/index.jsp";
    }
    @RequestMapping("/regist")
    public String regist(TbUser user){
        System.err.println(user.toString());
        userService.addUser(user);
        return "user1";
    }
}
