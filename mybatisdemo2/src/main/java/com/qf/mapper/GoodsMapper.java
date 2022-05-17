package com.qf.mapper;

import com.qf.pojo.TbGoods;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/5/16 19:33
 */

public interface GoodsMapper {
    List<TbGoods> findAll();
}
