package com.qf.feign;

import com.qf.pojo.Address;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.feign
 * @Description:
 * @Date 2022/6/26 22:51
 */
//@Component  // 当使用requestmapping 的时候，由于会产生问题，所以使用fallbackfactory，这个时候不能使用包扫描
public class AddressOpenFeignFallBack implements AddressOpenFeign {
    @Override
    public Address findById(Long id) {
        Address address = new Address();
        address.setId(-10000L);
        address.setName("降级返回");
        address.setPhone("-100");
        return address;
    }

    @Override
    public String test2(String name) {
        return "test2的降级数据";
    }

    @Override
    public String test3(String name, int age) {
        return "test3的降级数据";
    }

    @Override
    public Address test4(Address address) {
        address.setName("降级4的名字");
        return address;
    }
}
