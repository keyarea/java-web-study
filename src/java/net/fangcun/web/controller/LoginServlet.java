package net.fangcun.web.controller;

import net.fangcun.domain.User;
import net.fangcun.service.IUserService;
import net.fangcun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取用户填写的登录用户名
        String name = request.getParameter("name");
        // 获取用户填写的登录密码
        String password = request.getParameter("password");

        UserServiceImpl userService = UserServiceImpl.getInstance();

        // 用户登录
        User user = userService.loginUser(name, password);

        // TODO 用户登录
        if(user == null){

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }

}
