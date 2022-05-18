package com.qf.proxy;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.proxy
 * @Description:
 * @Date 2022/5/18 15:46
 */

public class FD implements Sellable {
    @Override
    public void qht(){
        System.err.println("FD类中的qht方法执行了-->");
    }

    @Override
    public void jq(double price) {
        System.err.println("FD类中的jq方法执行了-->"+price);
    }

}
