package com.qf.Controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.Controller
 * @Description:
 * @Date 2022/5/21 0:53
 */

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    @ResponseBody
    public User findByName(String username){
        User user = userService.findByName(username);
        return user;
    }


    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){
        return "asd";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Map test3(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("wanshang", "吃饭");
        hashMap.put("zaoshang", "吃饭");
        hashMap.put("zhongwu", "不吃饭");
        return hashMap;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public List<String> test4(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add("字符串:" + i);
        }
        return arrayList;
    }

    @RequestMapping("/test5")
    @ResponseBody
    public List<User> test5(){
        ArrayList<User> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("名字"+i);
            arrayList.add(user);
        }
        return arrayList;
    }


    @RequestMapping("/addUser")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        user.setPassword("asdasdasdas==>"+user.getPassword());
        return user;
    }
}
