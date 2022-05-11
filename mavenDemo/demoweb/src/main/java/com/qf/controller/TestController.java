package com.qf.controller;

import com.qf.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @version V1.0
 * @Project mavenDemo
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/5/10 14:46
 */
@WebServlet(urlPatterns = "/test")
public class TestController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(StringUtils.isEmpty("123"));
        System.out.println(StringUtils.isEmpty("123"));
    }
}
