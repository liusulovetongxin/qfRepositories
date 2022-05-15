package com.qf.mapper;

import com.qf.pojo.Product;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo1
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/12 10:28
 */

public interface ProductMapper {
    public List<Product> findAll();

    public List<Product> findProductAndOrder();
    public List<Product> findProductAndOrderAndUser();
}
