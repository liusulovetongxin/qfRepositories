package com.qf.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.utils
 * @Description:
 * @Date 2022/5/16 11:56
 */

public class MyBatisUtil {
    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> tl = new ThreadLocal<>();
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession openSession(){
        SqlSession sqlSession = tl.get();
        if (sqlSession == null) {
            sqlSession = factory.openSession();
            tl.set(sqlSession);
        }
        return sqlSession;
    }
    public static void commit(){
        SqlSession sqlSession = tl.get();
        sqlSession.commit();
        closeAll();

    }
    public static void rollback(){
        SqlSession sqlSession = tl.get();
        sqlSession.rollback();
        closeAll();
    }
    public static void  closeAll(){
        SqlSession sqlSession = tl.get();
        if (sqlSession != null) {
            sqlSession.close();
            tl.remove();
        }
    }
    public static <T extends Object>T getMapper(Class<T> clazz){
        SqlSession sqlSession = openSession();
        return sqlSession.getMapper(clazz);
    }
}
