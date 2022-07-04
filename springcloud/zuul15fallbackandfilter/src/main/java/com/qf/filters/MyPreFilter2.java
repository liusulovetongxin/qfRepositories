package com.qf.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.filters
 * @Description:
 * @Date 2022/6/27 20:35
 */

public class MyPreFilter2 extends ZuulFilter {
    /**
     * 过滤器的类型,分为前置,路由,后置,错误过滤器
     * @return
     */
    @Override
    public String filterType() {
        // return "pre";
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器的顺序,我们的过滤器会有很多个,这个数字来控制顺序,这个顺序仅限于相同类型的过滤器
     * 数字越小,优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        //这是一个内置的过滤器,我们的过滤器优先级建议要告诉这个值,不要低于它,否则容易出现空指针,特别是在转发服务的情况下
        return FilterConstants.PRE_DECORATION_FILTER_ORDER+100;
    }

    /**
     * 是否启用当前过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //根据业务来判断应该返回true还是false
        RequestContext currentContext = RequestContext.getCurrentContext();
        //根据前面过滤器是不是拦截来决定要不要开启这个过滤器
        return currentContext.sendZuulResponse();
        // return true;
    }

    /**
     * 我们过滤器要执行的操作
     * @return 不要更改返回值
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //我们过滤器要执行的操作
        System.err.println("MyPreFilter2222中的方法run 执行了");
        RequestContext currentContext = RequestContext.getCurrentContext();
        Object username = currentContext.get("username");
        System.err.println(username);

        //将请求转发到这个服务
        currentContext.set(FilterConstants.SERVICE_ID_KEY,"10addressproviderhystrix");
        //转发请求到上面服务的这个地址
        currentContext.set(FilterConstants.REQUEST_URI_KEY,"/address/test/2");
        return null;
    }
}
