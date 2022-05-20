package com.qf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.Controller
 * @Description:
 * @Date 2022/5/20 20:25
 */
@Controller
@RequestMapping("/test")
@SessionAttributes({"sessionkey1","sessionshuju2"})
public class TestController {

    @RequestMapping("/test1")
    public String test1(String username, HttpServletRequest request){
        request.setAttribute("username",username);
        System.err.println("TestController类中的test1方法执行了-->");
        return "/result.jsp";
    }

    @RequestMapping("/test2")
    public String test2(String username, Model model){
        model.addAttribute("username",username);
        return "/result.jsp";
    }

    @RequestMapping("/test3")
    public String test3(String username, Model model){
        model.addAttribute("mingzi",username);
        return "redirect:/result.jsp";
    }

    @RequestMapping("/test4")
    public ModelAndView test4(String username, ModelAndView view){
        view.setViewName("/result.jsp");
        view.addObject("username","收到的名字是"+username);
        return view;
    }
    @RequestMapping("/test5")
    public ModelAndView test5(String username, ModelAndView view){
        view.setViewName("redirect:/result2.jsp");
        view.addObject("sessionkey1","这是sessionkey1的数据");
        view.addObject("sessionshuju2","这是sessionshuju2的数据");
        return view;
    }

    @RequestMapping("/clear")
    public String hello(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "/";
    }
}
