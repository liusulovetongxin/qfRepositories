package com.qf.test;

import com.github.pagehelper.PageHelper;
import com.qf.mapper.GoodsMapper;
import com.qf.pojo.TbGoods;
import com.qf.utils.MyBatisUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/16 20:00
 */

public class TestPageHelper {
    @Test
    public void testFindAllByPageHelper(){
        GoodsMapper goodsMapper = MyBatisUtil.getMapper(GoodsMapper.class);
        PageHelper.startPage(1,10);
        List<TbGoods> list = goodsMapper.findAll();
//        PageInfo<TbGoods> pageInfo = new PageInfo<TbGoods>(list);
        if (list != null) {
            for (TbGoods goods : list) {
                System.out.println(goods.toString());
            }
        }
    }
}
