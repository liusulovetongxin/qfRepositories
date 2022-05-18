package com.qf.service.Impl;

import com.qf.dao.UserDao;
import com.qf.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service.Impl
 * @Description:
 * @Date 2022/5/18 12:07
 */
//@Component
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserServiceImpl implements UserService {
    private UserDao userDao;
//    @Autowired
//    @Qualifier("userDaoImpl")
    @Resource(name = "userDaoImpl")  //这个注解可以代替上边两个注解，一般多个对象的时候用
    public void setUserDao(UserDao userDao){
        this.userDao =userDao;
    }
    @Override
    public void addUser() {
        userDao.addUser();
    }
    @PostConstruct
    public void init(){
        System.err.println("UserServiceImpl中的init执行了"+userDao);
    }
    @PreDestroy
    public void destory(){
        System.err.println("UserServiceImpl中的destory执行了");
    }
}
