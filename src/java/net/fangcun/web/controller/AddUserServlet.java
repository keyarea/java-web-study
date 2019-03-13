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

@WebServlet(urlPatterns = "/admin/addUser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");

        if(name == null || nickname ==null || password == null){
            response.sendError(400, "错误的请求");
        }

        User user = new User();
        user.setName(name);
        user.setNickname(nickname);
        user.setPassword(password);

        IUserService userService = UserServiceImpl.getInstance();
        if(userService.findUser(name) == null){
            if(userService.addUser(user)){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("result", true);
                jsonObject.put("message", "成功添加用户");
                response.setContentType("application/json;charset=utf-8");
                PrintWriter writer = response.getWriter();
                writer.println(jsonObject);
            }else{
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("result", false);
                jsonObject.put("message", "添加用户失败");
                response.setContentType("application/json;charset=utf-8");
                PrintWriter writer = response.getWriter();
                writer.println(jsonObject);
            }
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", false);
            jsonObject.put("message", "该用户名已经存在！");
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println(jsonObject);
        }

    }

}
