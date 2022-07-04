package com.qf.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloud
 * @Package com.qf.filters
 * @Description:
 * @Date 2022/6/27 20:35
 */

public class MyPostFilter extends ZuulFilter {
    /**
     * 过滤器的类型,分为前置,路由,后置,错误过滤器
     * @return
     */
    @Override
    public String filterType() {
        // return "post";
        return FilterConstants.POST_TYPE;
    }

    /**
     * 过滤器的顺序,我们的过滤器会有很多个,这个数字来控制顺序,这个顺序仅限于相同类型的过滤器
     * 数字越小,优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return -1;
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
        System.err.println("MyPostFilter中的方法run 执行了");
        RequestContext currentContext = RequestContext.getCurrentContext();
        Object username = currentContext.get("username");
        System.err.println(username);
        //获取请求的下游服务的结果,这个操作只能在post类型的过滤器中处理,因为其他的过滤器还没有请求服务
        InputStream inputStream = currentContext.getResponseDataStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;

        try {
            while ((line = reader.readLine())!=null) {
                System.err.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
