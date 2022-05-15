package com.qf.test;

import com.qf.Utils.MybatisUtils;
import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo1
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/12 10:00
 */

public class TestUserMapper {

    @Test
    public void testFindAll() throws Exception{
        // 通过流加载mybatis核心配置文件
        String str = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(str);
        // 创建会话工厂，工厂读取核心配置文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        is.close();
        // 根据会话工厂创建会话
        SqlSession sqlSession = factory.openSession();
        //根据会话引入mapper实体
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行mapper实体的方法
        List<User> users = mapper.findAll();
        // 执行SQL语句并返回结果
        System.out.println(users.toString());
        sqlSession.close();
    }

    @Test
    public void testFindOne() throws Exception{
//        MybatisUtils.openSession();
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        System.out.println(user.toString());
    }
    @Test
    public void testFindLike() throws Exception {
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        String likeName ="王%' or 1=1 #";
        List<User> like = userMapper.findLike(likeName);
        System.out.println(like.toString());
    }
    @Test
    public void testInsert() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User(null, "测试", "123456", "男", sdf.parse("2000-01-01"), new Date());
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        System.out.println(user.toString());
        try {
            userMapper.insertInto(user);
            MybatisUtils.commit();
            System.out.println(user.toString());
        } catch (Exception e) {
            MybatisUtils.rollback();
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testUpdateUserById()throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User(28, "测试", "123456", "男", sdf.parse("2000-01-01"), new Date());
        user.setName("饕餮");
        user.setPassword("123");
        user.setSex("女");
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        try {
            userMapper.updateUserById(user);
            MybatisUtils.commit();
        } catch (Exception e) {
            MybatisUtils.rollback();
            throw new RuntimeException(e);
        }
    }
    @Test
    public void tesDeleteById()throws Exception{
        MybatisUtils.openSession();
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        try {
            userMapper.deleteById(28);
            MybatisUtils.commit();
        } catch (Exception e) {
            MybatisUtils.rollback();
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testSelectByNameAndPwd()throws Exception{
        MybatisUtils.openSession();
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        User user = userMapper.selectByNameAndPwd("张三", "123");
        if (user != null) {
            System.out.println(user.toString());
        }
    }
    @Test
    public void testSelectByNameAndPwdMap()throws Exception{
        MybatisUtils.openSession();
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("myName", "张三");
        map.put("myPassword", "123");

        User user = userMapper.selectByNameAndPwd("张三", "123");
        if (user != null) {
            System.out.println(user.toString());
        }

    }
    @Test
    public void testDeleteByName(){
        MybatisUtils.openSession();
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        try {
            userMapper.deleteByName("测试");
            MybatisUtils.commit();
        } catch (Exception e) {
            MybatisUtils.rollback();
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testFindByNameAndSexAndPwd(){
        User user = new User();
//        user.setName("张");
        user.setSex("男");
        user.setPassword("123");
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        List<User> users = userMapper.findByNameAndSexAndPwd(user);
        System.out.println(users.toString());

    }
    @Test
    public void testFindByIds(){
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<User> list = userMapper.findByIds(ids);
        System.out.println(list.toString());
    }

    @Test
    public void testFindAllTemp(){
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        List<User> allTemp = userMapper.findAllTemp();
        for (User user : allTemp) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testFindUserAndDesc(){
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserAndDesc();
        if (list != null) {
            for (User user : list) {
                System.out.println(user.toString());
            }
        }
    }
}
