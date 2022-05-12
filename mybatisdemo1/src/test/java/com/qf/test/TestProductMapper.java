package com.qf.test;

import com.qf.mapper.ProductMapper;
import com.qf.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo1
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/12 10:31
 */

public class TestProductMapper {

    @Test
    public void TestFindAll()throws Exception{
        //通过流加载配置文件
        String str = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(str);
        // 通过配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //根据工厂创建会话
        SqlSession sqlSession = factory.openSession();
        // 根据会话创建mapper实体
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        //执行实体对象的方法
        List<Product> products = productMapper.findAll();
        System.out.println(products.toString());
    }
}
