package com.qf.test;

import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        String str = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(str);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        System.out.println(user.toString());
        is.close();
        sqlSession.close();
    }
    @Test
    public void testFindLike() throws Exception {
        String str = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(str);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        is.close();
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String likeName ="王%' or 1=1 #";
        List<User> like = userMapper.findLike(likeName);
        System.out.println(like.toString());

    }
    @Test
    public void testInsert() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User(null, "测试", "123456", "男", sdf.parse("2000-01-01"), new Date());
        String str = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(str);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        is.close();
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(user.toString());
        try {
            userMapper.insertInto(user);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            System.out.println(e.getMessage());
        }
    }
}
