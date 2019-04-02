package net.fangcun.web.controller;

import net.fangcun.dao.impl.CategoryDaoImpl;
import net.fangcun.domain.Category;
import net.fangcun.service.ICategoryService;
import net.fangcun.service.impl.CategoryServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/getCategory")
public class FindCategoryByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        ICategoryService categoryService = CategoryServiceImpl.getInstance();
        Category category = categoryService.find(id);
        response.setContentType("application/json;charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("id", category.getId());
        json.put("name", category.getName());
        response.getWriter().print(json);
    }
}
