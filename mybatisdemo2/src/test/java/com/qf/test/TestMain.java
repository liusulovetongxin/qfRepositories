package com.qf.test;

import com.qf.mapper.UserMapper;
import com.qf.pojo.TUsers;
import com.qf.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/16 11:17
 */

public class TestMain {
    @Test
    public void testFindAll()throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<TUsers> list = userMapper.findAll();
        if (list != null) {
            for (TUsers tUsers : list) {
                System.err.println(tUsers.toString());
            }
        }
    }


    @Test
    public void testFindById(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        TUsers user = userMapper.findById(1L);
        System.err.println(user.toString());
    }
    @Test
    public void testFindByUserNameAndPasswordWithMap(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        Map map = new HashMap();
        map.put("name", "张三");
        map.put("password", "123");
        TUsers user = userMapper.findByUserNameAndPasswordWithMap(map);
        System.err.println(user.toString());
    }
    @Test
    public void testFindByUnameAndPasswordWithPojo(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        TUsers tUsers = new TUsers();
        tUsers.setName("张三");
        tUsers.setPassword("123");
        TUsers user = userMapper.findByUnameAndPasswordWithPojo(tUsers);
        System.err.println(user.toString());
    }
    @Test
    public void testFindByUnameAndPassword(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        TUsers user = userMapper.findByUnameAndPassword("张三","123");
        System.err.println(user.toString());
    }
    @Test
    public void testFindByNameLike(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        List<TUsers> list = userMapper.findByNameLike("张");
        if (list != null) {
            for (TUsers user : list) {
                System.err.println(user.toString());
            }
        }
    }
    @Test
    public void testFindBySexLike(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        List<TUsers> list = userMapper.findBySexLike("男");
        if (list != null) {
            for (TUsers user : list) {
                System.err.println(user.toString());
            }
        }
    }
}
