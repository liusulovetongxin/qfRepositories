package com.qf.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.feign
 * @Description:
 * @Date 2022/6/26 22:59
 */
@Component
public class AddressOpenFeignFallBackFactory implements FallbackFactory<AddressOpenFeign> {
    @Override
    public AddressOpenFeign create(Throwable throwable) {
        return new AddressOpenFeignFallBack();
    }
}
