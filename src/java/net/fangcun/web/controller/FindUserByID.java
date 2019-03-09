package net.fangcun.web.controller;

import net.fangcun.domain.User;
import net.fangcun.service.IUserService;
import net.fangcun.service.impl.UserServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/admin/getUser")
public class FindUserByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));

        IUserService userService = UserServiceImpl.getInstance();
        User user = userService.findUser(id);
        response.setContentType("application/json;charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("id", user.getId());
        json.put("name", user.getName());
        json.put("nickname", user.getNickname());
        json.put("password", user.getPassword());
        response.getWriter().print(json);
    }
}
