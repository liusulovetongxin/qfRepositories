package com.qf.Controller;

import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project ssmtest
 * @Package com.qf.Controller
 * @Description:
 * @Date 2022/5/21 17:51
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/test1")
    public String test1(HttpServletRequest request){
        List<TbUser> list = userService.findAll();
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }
        request.setAttribute("list", list);
        return "/index.jsp";
    }

    @RequestMapping("test2")
    @ResponseBody
    public List<TbUser> test2(){
        List<TbUser> list = userService.findAll();
        return list;
    }
}
