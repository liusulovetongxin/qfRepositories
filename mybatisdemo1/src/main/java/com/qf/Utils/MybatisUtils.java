package com.qf.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo1
 * @Package com.qf
 * @Description:
 * @Date 2022/5/12 16:31
 */

public class MybatisUtils {
    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> tl=new ThreadLocal<>();

    static{
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession openSession(){
        SqlSession sqlSession = tl.get();
        if (sqlSession==null){
            sqlSession = factory.openSession();
            tl.set(sqlSession);
        }
        return sqlSession;
    }
    public static void closeSession(){
        SqlSession sqlSession =tl.get();
        sqlSession.close();
        tl.remove();
    }
    public static void commit(){
        SqlSession sqlSession = tl.get();
        sqlSession.commit();
        closeSession();
    }
    public static void rollback(){
        SqlSession sqlSession = tl.get();
        sqlSession.rollback();
        closeSession();
    }
    public static <T extends Object> T getMapper(Class<T> clazz){
        SqlSession sqlSession = openSession();
        return sqlSession.getMapper(clazz);
    }
}
