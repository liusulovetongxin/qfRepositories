package com.qf.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.servlet
 * @Description:
 * @Date 2022/5/20 9:26
 */
@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String option = req.getParameter("option");
        switch (option){
            case "add":
                add(req,resp);
                break;
            case "update":
                update(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case "findAll":
                findAll(req,resp);
                break;
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        System.err.println("添加功能执行了");
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        System.err.println("删除功能执行了");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) {
        System.err.println("更新功能执行了");
    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) {
        System.err.println("查询所有功能执行了");
    }
}
