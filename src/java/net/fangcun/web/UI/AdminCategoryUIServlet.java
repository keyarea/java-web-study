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
        ICategoryService categoryService = CategoryServiceImpl.getInstance();
        Category[] categories = categoryService.find();
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
