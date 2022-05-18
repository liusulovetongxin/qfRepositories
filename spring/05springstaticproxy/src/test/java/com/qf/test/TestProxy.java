package com.qf.test;

import com.qf.proxy.FD;
import com.qf.proxy.ZJ;
import org.junit.Test;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.test
 * @Description:
 * @Date 2022/5/18 15:49
 */

public class TestProxy {
    @Test
    public void testProxy(){
        FD fd = new FD();
        ZJ zj = new ZJ();
        zj.setSellable(fd);
        zj.qht();
        zj.jq(1111);
    }
}
