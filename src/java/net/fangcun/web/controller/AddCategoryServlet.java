package net.fangcun.web.controller;

import net.fangcun.dao.ICategoryDao;
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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/admin/addCategory")
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

        ICategoryService categoryService = CategoryServiceImpl.getInstance();
        boolean isExist = categoryService.isExist(name);
        JSONObject jsonObject = new JSONObject();

        if(isExist){
            jsonObject.put("result", false);
            jsonObject.put("message", "存在该分类名称");
        }else{
            Category category = new Category();
            category.setName(name);

            boolean result = categoryService.addCategory(category);

            if(result){
                jsonObject.put("result", true);
                jsonObject.put("message", "成功添加分类");
            }else{
                jsonObject.put("result", false);
                jsonObject.put("message", "添加分类失败");
            }

        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(jsonObject);
        writer.flush();
        writer.close();

    }
}
