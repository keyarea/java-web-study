package net.fangcun.web.controller;

import net.fangcun.domain.Category;
import net.fangcun.service.ICategoryService;
import net.fangcun.service.impl.CategoryServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getAllCategoryServlet", urlPatterns = "/getAllCategory")
public class getAllCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 取得分类服务的实例化对象
        ICategoryService categoryService = CategoryServiceImpl.getInstance();

        // 调用服务接口获取所有分类
        Category[] categories = categoryService.find();

        // 创建json
        JSONArray res = new JSONArray();

        for (Category category: categories){
            JSONObject resItem = new JSONObject();
            resItem.put("id", category.getId());
            resItem.put("name", category.getName());
            res.put(resItem);
        }

        response.setContentType("application/json;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.print(res);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
