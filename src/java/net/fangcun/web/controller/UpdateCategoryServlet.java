package net.fangcun.web.controller;

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

@WebServlet(urlPatterns = "/admin/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        ICategoryService categoryService = CategoryServiceImpl.getInstance();
        boolean result = categoryService.updateCategory(category);

        JSONObject jsonObject = new JSONObject();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        if(result){
            jsonObject.put("result", true);
            jsonObject.put("message", "修改分类成功！");
        }else{
            jsonObject.put("result", false);
            jsonObject.put("message", "修改分类失败！");
        }
        printWriter.println(jsonObject);
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        doPost(request, response);
    }
}
