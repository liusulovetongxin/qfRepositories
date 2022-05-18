package com.qf.proxy;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.proxy
 * @Description:
 * @Date 2022/5/18 15:46
 */

public class ZJ implements Sellable{
    private Sellable sellable;

    public void setSellable(Sellable sellable){
        this.sellable = sellable;
    }
    @Override
    public void qht() {
        System.err.println("中介带着去看房子");
        System.err.println("中介带着去找房东签合同");
        System.err.println("ZJ类中的qht方法执行了-->");
        sellable.qht();
    }

    @Override
    public void jq(double price) {
        System.err.println("中介带着去找房东交钱");
        System.err.println("ZJ类中的jq方法执行了-->"+price);
        sellable.jq(price);
    }
}
