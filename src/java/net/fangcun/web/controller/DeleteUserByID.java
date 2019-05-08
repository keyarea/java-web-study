package net.fangcun.web.controller;

import net.fangcun.service.IUserService;
import net.fangcun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/admin/deleteUser")
public class DeleteUserByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String pattern = "^\\d+$";
        String userID = request.getParameter("id");

        boolean access = Pattern.matches(pattern, userID);
        if(!access){
            response.sendError(400, "错误的请求参数");
        }

        try{
            int id = Integer.parseInt(userID);
            boolean result = UserServiceImpl.getInstance().deleteUser(id);

            if(result){
                response.setStatus(200);
            }else{
                throw new Exception("删除用户失败！");
            }
        }catch (Exception e){
            response.sendError(500, e.getMessage());
        }

    }
}
