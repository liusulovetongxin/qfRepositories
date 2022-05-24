package com.qf.interceptor;

import com.qf.constant.ResultCode;
import com.qf.exceptions.BaseException;
import org.springframework.util.Assert;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @version V1.0
 * @Project MySSMdemo1
 * @Package com.qf.interceptor
 * @Description:
 * @Date 2022/5/25 1:43
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        Assert.notNull(user,()->{
            throw new BaseException("未登录", ResultCode.NOT_LOGIN);
        });
        return true;
    }
}
