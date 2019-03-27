package net.fangcun.web.controller;

import net.fangcun.dao.ICategoryDao;
import net.fangcun.domain.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        String name = request.getParameter("name");

        if(name == null || name.trim().equals("")){
            response.sendError(400, "错误的请求");
        }

        Category category = new Category();
        category.setName(name);
    }
}
