package com.qf.test;

import com.qf.mapper.PassportMapper;
import com.qf.mapper.UserMapper;
import com.qf.pojo.TbPassportuser;
import com.qf.pojo.TbUser;
import com.qf.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
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
        List<TbUser> list = userMapper.findAll();
        if (list != null) {
            for (TbUser tUsers : list) {
                System.err.println(tUsers.toString());
            }
        }
    }


    @Test
    public void testFindById(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        TbUser user = userMapper.findById(1L);
        System.err.println(user.toString());
    }
    @Test
    public void testFindByUserNameAndPasswordWithMap(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        Map map = new HashMap();
        map.put("username", "张三");
        map.put("password", "123");
        TbUser user = userMapper.findByUserNameAndPasswordWithMap(map);
        System.err.println(user.toString());
    }
    @Test
    public void testFindByUnameAndPasswordWithPojo(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        TbUser tUsers = new TbUser();
        tUsers.setUsername("张三");
        tUsers.setPassword("123");
        TbUser user = userMapper.findByUnameAndPasswordWithPojo(tUsers);
        System.err.println(user.toString());
    }
    @Test
    public void testFindByUnameAndPassword(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        TbUser user = userMapper.findByUnameAndPassword("张三","123");
        System.err.println(user.toString());
    }
    @Test
    public void testFindByNameLike(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        List<TbUser> list = userMapper.findByNameLike("张");
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }
    }
    @Test
    public void testFindBySexLike(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        List<TbUser> list = userMapper.findBySexLike("男");
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }
    }

    @Test
    public void testFindWithOrderByUid(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        TbUser user = userMapper.findWithOrderByUid(3);
        System.err.println(user.toString());
    }
    @Test
    public void testpassport(){
        PassportMapper passportMapper = MyBatisUtil.getMapper(PassportMapper.class);
        TbPassportuser user = passportMapper.findById(1);
        System.err.println(user.toString());
    }
    @Test
    public void testFindByMulti(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
        Map map = new HashMap();
        map.put("username", "zhangsan");
        List<TbUser> list = userMapper.findByMulti(map);
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }
    }
    @Test
    public void testFindByIds(){
        UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);
       List<Long> Longs = new ArrayList<>();
       Longs.add(1L);
       Longs.add(2L);
       Longs.add(3L);
        List<TbUser> list = userMapper.findByIds(Longs);
        if (list != null) {
            for (TbUser user : list) {
                System.err.println(user.toString());
            }
        }
    }

    @Test
    public void testUpdateById(){
        PassportMapper passportMapper = MyBatisUtil.getMapper(PassportMapper.class);
        TbPassportuser tbPassportuser = new TbPassportuser();
        tbPassportuser.setId(1L);
        tbPassportuser.setSex("女");
        tbPassportuser.setName("李四");
        passportMapper.updateById(tbPassportuser);
        MyBatisUtil.commit();
    }
}
