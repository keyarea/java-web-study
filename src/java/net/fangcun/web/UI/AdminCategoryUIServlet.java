package net.fangcun.web.UI;

import net.fangcun.domain.Category;
import net.fangcun.service.ICategoryService;
import net.fangcun.service.impl.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/category")
public class AdminCategoryUIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 得到分类操作的实例
        ICategoryService categoryService = CategoryServiceImpl.getInstance();
        // 得到所有的分类
        Category[] categories = categoryService.find();
        // 为分类数组添加分类下文章
        categories = categoryService.addArticles(categories);
        // 给请求添加属性
        request.setAttribute("categories", categories);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/admin-category.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}
