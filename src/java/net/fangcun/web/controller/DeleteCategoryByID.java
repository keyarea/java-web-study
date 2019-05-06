package net.fangcun.web.controller;

import net.fangcun.service.impl.CategoryServiceImpl;
import net.fangcun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/admin/deleteCategory")
public class DeleteCategoryByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        String categoryID = request.getParameter("id");

        if(categoryID == null){
            response.setStatus(400);
        }

        try{
            int id = Integer.parseInt(categoryID);
            boolean result = CategoryServiceImpl.getInstance().delete(id);

            if(result){
                response.setStatus(200);
            }else{
                throw new Exception("删除分类失败！");
            }
        }catch (Exception e){
            response.setStatus(500);
        }
    }
}
