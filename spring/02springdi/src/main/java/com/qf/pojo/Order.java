package com.qf.pojo;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/5/18 12:04
 */

public class Order {
    private Item item;

    private Address address;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "item=" + item +
                ", address=" + address +
                '}';
    }
}
