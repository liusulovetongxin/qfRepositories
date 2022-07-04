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

public class MyPreFilter1 extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        return context.sendZuulResponse();
    }

    @Override
    public Object run() throws ZuulException {
        //我们过滤器要执行的操作
        System.err.println("MyPreFilter1中的方法run 执行了");
        //获取当前的上线文,以线程为区分,内部是threadlocal
        RequestContext currentContext = RequestContext.getCurrentContext();
        //存放数据
        currentContext.set("username", "zhangsan");
        //拦截请求
        //    currentContext.setSendZuulResponse(false);
        //直接设置返回结果
        // currentContext.setResponseBody("直接设置返回结果");
        //设置返回值类型
        // currentContext.addZuulResponseHeader("content-Type", "text/html;charset=utf-8");
        //获取请求对象
        //      HttpServletRequest request = currentContext.getRequest();
        //获取到响应对象
        //    HttpServletResponse response = currentContext.getResponse();
//        response.addHeader("content-Type", "text/html;charset=utf-8");
//        try {
//            response.getWriter().write("这是response返回的数据");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }
}
