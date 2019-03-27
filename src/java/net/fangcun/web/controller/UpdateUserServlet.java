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

@WebServlet(urlPatterns = "/admin/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        String nickname = request.getParameter("nickname");
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(nickname == null && id == null && password == null){
            response.sendError(400, "错误的请求");
        }

        User user = new User();
        user.setId(id);
        user.setNickname(nickname);
        user.setPassword(password);

        IUserService userService = UserServiceImpl.getInstance();
        if(userService.updateUser(user)){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", true);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(jsonObject);
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", false);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(jsonObject);
        }
    }
}
