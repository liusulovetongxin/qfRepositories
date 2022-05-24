package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.dto.R;
import com.qf.pojo.TbUser;
import com.qf.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/5/24 19:37
 */
@RestController
@RequestMapping("users")
public class TUserController {
    private TUserService tUserService;
    @Autowired
    public void settUserService(TUserService tUserService) {
        this.tUserService = tUserService;
    }

    @PostMapping("/user")
    public R addUser(@RequestBody TbUser tbUser){
        tUserService.addUser(tbUser);
        return R.setOk();
    }

    @PostMapping("/update")
    public R update(@RequestBody TbUser tbUser){
        tUserService.updateUser(tbUser);
        return R.setOk();
    }

    @GetMapping("/users")
    public R findAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "5") int pageSize){
        PageInfo<TbUser> data = tUserService.findAll(pageNum, pageSize);
        return R.setOk(data);
    }

    @GetMapping("/user/{id}")
    public R findById(@PathVariable Long id){
        TbUser tbUser = tUserService.findById(id);
        return R.setOk(tbUser);
    }
    @PostMapping("/login")
    public R login(@RequestBody TbUser tbUser, HttpSession session){
        TbUser tbUser1 = tUserService.findByUserName(tbUser);
        session.setAttribute("user", tbUser1);
        return R.setOk();
    }


}
